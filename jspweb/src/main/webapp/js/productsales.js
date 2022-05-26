
let jsonlist;
let piejsonlist;



$(function(){
	$.ajax({
		url : "getchart",
		success : function(result){
			jsonlist = result;
			
			////////////////////////////////////////// am chart ///////////////////////////////////
			am5.ready(function() {
			
			// Create root element
			// https://www.amcharts.com/docs/v5/getting-started/#Root_element
			var root = am5.Root.new("chartdiv");
			
			
			// Set themes
			// https://www.amcharts.com/docs/v5/concepts/themes/
			root.setThemes([
			  am5themes_Animated.new(root)
			]);
			
			
			// Create chart
			// https://www.amcharts.com/docs/v5/charts/xy-chart/
			var chart = root.container.children.push(am5xy.XYChart.new(root, {
			  panX: false,
			  panY: false,
			  wheelX: "panX",
			  wheelY: "zoomX"
			}));
			
			
			// Add cursor
			// https://www.amcharts.com/docs/v5/charts/xy-chart/cursor/
			var cursor = chart.set("cursor", am5xy.XYCursor.new(root, {
			  behavior: "zoomX"
			}));
			cursor.lineY.set("visible", false);

			function generateData(i) {
				// i번째 객체에서 값 가져오기
			  	let value = parseInt(jsonlist[i]["value"]);
			  	// i번째 객체에서 날짜 가져오기
			  		// * 문자열 -> 날짜형식 변환 new Date("날짜형식문자")
			  	let date = new Date(jsonlist[i]["date"]);
			 	date.setHours(0, 0, 0, 0);
			  am5.time.add(date, "day", 0);
			  return {
			    date: date.getTime(),
			    value: value
			  };
			}
			
			function generateDatas(count) {
			  var data = [];
			  for (var i = 0; i < count; ++i) {
			    data.push(generateData(i));	// i 를 인수로 전달
			  }
			  return data;
			}
			
			
			// Create axes
			// https://www.amcharts.com/docs/v5/charts/xy-chart/axes/
			var xAxis = chart.xAxes.push(am5xy.DateAxis.new(root, {
			  maxDeviation: 0,
			  baseInterval: {
			    timeUnit: "day",
			    count: 1
			  },
			  renderer: am5xy.AxisRendererX.new(root, {}),
			  tooltip: am5.Tooltip.new(root, {})
			}));
			
			var yAxis = chart.yAxes.push(am5xy.ValueAxis.new(root, {
			  renderer: am5xy.AxisRendererY.new(root, {})
			}));
			
			
			// Add series
			// https://www.amcharts.com/docs/v5/charts/xy-chart/series/
			var series = chart.series.push(am5xy.ColumnSeries.new(root, {
			  name: "Series",
			  xAxis: xAxis,
			  yAxis: yAxis,
			  valueYField: "value",
			  valueXField: "date",
			  tooltip: am5.Tooltip.new(root, {
			    labelText: "{valueY}"
			  })
			}));
			
			
			
			// Add scrollbar
			// https://www.amcharts.com/docs/v5/charts/xy-chart/scrollbars/
			chart.set("scrollbarX", am5.Scrollbar.new(root, {
			  orientation: "horizontal"
			}));
			
			var data = generateDatas(jsonlist.length);	// 1. 차트에 들어가는 데이터 [인수 : 객체수]
			series.data.setAll(data);
			
			
			// Make stuff animate on load
			// https://www.amcharts.com/docs/v5/concepts/animations/
			series.appear(1000);
			chart.appear(1000, 100);
			
			}); // end am5.ready()
			
			///////////////////////////////////////////////////////////////////////
			
		}
	});
	
	$.ajax({
		url : "getchart",
		data : {"field" : 'pie'},
		success : function(result){
			piejsonlist = result;
			console.log(piejsonlist);
			
			////////////////////////////////////// am 원형차트 ////////////////////////////////////////
			am5.ready(function() {
				// Create root element
				// https://www.amcharts.com/docs/v5/getting-started/#Root_element
				var root = am5.Root.new("piechartdiv");
				
				// Set themes
				// https://www.amcharts.com/docs/v5/concepts/themes/
				root.setThemes([
				  am5themes_Animated.new(root)
				]);
				
				// Create chart
				// https://www.amcharts.com/docs/v5/charts/percent-charts/pie-chart/
				var chart = root.container.children.push(
				  am5percent.PieChart.new(root, {
				    endAngle: 270
				  })
				);
				
				// Create series
				// https://www.amcharts.com/docs/v5/charts/percent-charts/pie-chart/#Series
				var series = chart.series.push(
				  am5percent.PieSeries.new(root, {
				    valueField: "value",
				    categoryField: "category",
				    endAngle: 270
				  })
				);
				
				series.states.create("hidden", {
				  endAngle: -90
				});
				
				// Set data
				// https://www.amcharts.com/docs/v5/charts/percent-charts/pie-chart/#Setting_data
				series.data.setAll(piejsonlist);
				
				series.appear(1000, 100);
			
			}); // end am5.ready()
			//////////////////////////////////////////////////////////////////////////////////////////////////
		}
	});

	
});



function getchart(pname){
	
	let linejsonlist = [];
	$.ajax({
		url : "getchart",
		data : {"field" : 'line'},
		success : function(result){
			
			
			let temp = result;
			for(let i=0; i<temp.length; i++){
				if(temp[i]["pname"] == pname){
					linejsonlist.push(temp[i]);	
				}
			}

			
			/////////////////////////////////////////// 선 차트 //////////////////////////////////////////////
			am5.ready(function() {
				
				// Create root element
				// https://www.amcharts.com/docs/v5/getting-started/#Root_element
				var root = am5.Root.new("linechartdiv");
				
				// Set themes
				// https://www.amcharts.com/docs/v5/concepts/themes/
				root.setThemes([
				  am5themes_Animated.new(root)
				]);
				
				
				// Create chart
				// https://www.amcharts.com/docs/v5/charts/xy-chart/
				var chart = root.container.children.push(am5xy.XYChart.new(root, {
				  panX: true,
				  panY: true,
				  wheelX: "panX",
				  wheelY: "zoomX",
				  pinchZoomX:true
				}));
				
				
				// Add cursor
				// https://www.amcharts.com/docs/v5/charts/xy-chart/cursor/
				var cursor = chart.set("cursor", am5xy.XYCursor.new(root, {
				  behavior: "none"
				}));
				cursor.lineY.set("visible", false);
				
				
			
				
				function generateData(i) {
					  // i번째 객체에서 값 가져오기
				  	let value = parseInt(linejsonlist[i]["value"]);
				  	// i번째 객체에서 날짜 가져오기
				  		// * 문자열 -> 날짜형식 변환 new Date("날짜형식문자")
				  	let date = new Date(linejsonlist[i]["date"]);
				 	date.setHours(0, 0, 0, 0);
				  am5.time.add(date, "day", 1);
				  return {
				    date: date.getTime(),
				    value: value
				  };
				}
				
				function generateDatas(count) {
				  var data = [];
				  for (var i = 0; i < count; ++i) {
				    data.push(generateData(i));
				  }
				  return data;
				}
				
				
				// Create axes
				// https://www.amcharts.com/docs/v5/charts/xy-chart/axes/
				var xAxis = chart.xAxes.push(am5xy.DateAxis.new(root, {
				  maxDeviation: 0.2,
				  baseInterval: {
				    timeUnit: "day",
				    count: 1
				  },
				  renderer: am5xy.AxisRendererX.new(root, {}),
				  tooltip: am5.Tooltip.new(root, {})
				}));
				
				var yAxis = chart.yAxes.push(am5xy.ValueAxis.new(root, {
				  renderer: am5xy.AxisRendererY.new(root, {})
				}));
				
				
				// Add series
				// https://www.amcharts.com/docs/v5/charts/xy-chart/series/
				var series = chart.series.push(am5xy.LineSeries.new(root, {
				  name: "Series",
				  xAxis: xAxis,
				  yAxis: yAxis,
				  valueYField: "value",
				  valueXField: "date",
				  tooltip: am5.Tooltip.new(root, {
				    labelText: "{valueY}"
				  })
				}));
				
				
				// Add scrollbar
				// https://www.amcharts.com/docs/v5/charts/xy-chart/scrollbars/
				chart.set("scrollbarX", am5.Scrollbar.new(root, {
				  orientation: "horizontal"
				}));
				
				
				// Set data
				var data = generateDatas(linejsonlist.length);
				series.data.setAll(data);
				
				
				// Make stuff animate on load
				// https://www.amcharts.com/docs/v5/concepts/animations/
				series.appear(1000);
				chart.appear(1000, 100);
				
				
			}); // end am5.ready()
			/////////////////////////////////////////////////////////////////////////////////
		}
	});
	

	
}


