 var btn = document.getElementById("ajax_btn");

    btn.addEventListener("click", () => {
        //XMLHttpRequest 객체 생성
        var xhr = new XMLHttpRequest();

        //요청을 보낼 방식, 주소, 비동기여부 설정
        xhr.open('GET', 'Idcheck?id=asdf', true);

        //요청 전송
        xhr.send();

        //통신후 작업
        xhr.onload = () => {
            //통신 성공
            if (xhr.status == 200) {
                console.log(xhr.response);
                console.log("통신 성공");
            } else {
                //통신 실패
                console.log("통신 실패");
            }
        }
    });