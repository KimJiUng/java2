package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.게임판Dao;
import dao.플레이어Dao;
import dto.게임판;
import dto.플레이어;

/**
 * Servlet implementation class gamapan
 */
@WebServlet("/gamepan")
public class gamepan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gamepan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<게임판> 게임판리스트 = 게임판Dao.게임판Dao.게임판리스트();
		ArrayList<플레이어> plist = 플레이어Dao.플레이어Dao.getplayers(1);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String html = "";
		html += "<div class=\"row\" id=\"a\">";
		for(int i=1; i<=121; i++){
			for(게임판 temp : 게임판리스트){
				if(i%11==1 && (temp.get게임판위치()+(i/11))==20 ){ 
					html +=	"<div id=\"game"+i+"\" class=\"gameboard col-md-1 offset-1\">"+temp.get게임판위치()+" <br>"+temp.get도시이름()+"<br>";
					for(플레이어 player : plist){ 
						if(temp.get게임판위치()==player.get현재위치()){ 
							html+= "<span";
							if(player.get순서()==1){ 
								html += " style=\"color: red;\"";
							} else if(player.get순서()==2){ 
								html += " style=\"color: blue;\"";
							} else if(player.get순서()==3){
								html += "< style=\"color: green;\"";
							} else if(player.get순서()==4){ 
								html += "< style=\"color: purple;\"";
							}
							html += ">"+ player.get플레이어닉네임()+"</span><br>";
						}else {}
					}
					html += "</div>";
				}else if(i>1 && i<12 &&temp.get게임판위치()-i==19){ 
					html +=	"<div id=\"game"+i+"\" class=\"gameboard col-md-1\">"+temp.get게임판위치()+" <br>"+temp.get도시이름()+"<br>";
					for(플레이어 player : plist){ 
						if(temp.get게임판위치()==player.get현재위치()){ 
							html+= "<span";
							if(player.get순서()==1){ 
								html += " style=\"color: red;\"";
							} else if(player.get순서()==2){ 
								html += " style=\"color: blue;\"";
							} else if(player.get순서()==3){
								html += "< style=\"color: green;\"";
							} else if(player.get순서()==4){ 
								html += "< style=\"color: purple;\"";
							}
							html += ">"+ player.get플레이어닉네임()+"</span><br>";
						}else {}
					}
					html += "</div>";
				}else if(i%11==0 && (temp.get게임판위치()-(i/11))==29) {
					html +=	"<div id=\"game"+i+"\" class=\"gameboard col-md-1\">"+temp.get게임판위치()+" <br>"+temp.get도시이름()+"<br>";
					for(플레이어 player : plist){ 
						if(temp.get게임판위치()==player.get현재위치()){ 
							html+= "<span";
							if(player.get순서()==1){ 
								html += " style=\"color: red;\"";
							} else if(player.get순서()==2){ 
								html += " style=\"color: blue;\"";
							} else if(player.get순서()==3){
								html += "< style=\"color: green;\"";
							} else if(player.get순서()==4){ 
								html += "< style=\"color: purple;\"";
							}
							html += ">"+ player.get플레이어닉네임()+"</span><br>";
						}else {}
					}
					html += "</div>";
				}else if(i>111 && i<121 && temp.get게임판위치()+i==121) { 
					html +=	"<div id=\"game"+i+"\" class=\"gameboard col-md-1\">"+temp.get게임판위치()+" <br>"+temp.get도시이름()+"<br>";
					for(플레이어 player : plist){ 
						if(temp.get게임판위치()==player.get현재위치()){ 
							html+= "<span";
							if(player.get순서()==1){ 
								html += " style=\"color: red;\"";
							} else if(player.get순서()==2){ 
								html += " style=\"color: blue;\"";
							} else if(player.get순서()==3){
								html += "< style=\"color: green;\"";
							} else if(player.get순서()==4){ 
								html += "< style=\"color: purple;\"";
							}
							html += ">"+ player.get플레이어닉네임()+"</span><br>";
						}else {}
					}
					html += "</div>";
				} 			
			} 
			if((i>12 && i<110) && (i%11>1 && i%11<11) ) {
			 html += "<div class=\"gameboard col-md-1\" style=\"border: none;\"></div>";
			} 
		}
		html += "</div>";
		out.print(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
