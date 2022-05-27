package controller.board;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.json.JSONArray;
import org.json.JSONObject;

// @WebServlet : URL 매핑
// @WebServlet("HTTP 클래스로 들어오는 경로 정의")
// @ServerEndpoint("서버소켓 클래스로 들어오는 경로 정의")
@ServerEndpoint("/board/Chatting2/{mid}")
public class Chatting2 {	// 서버소켓 사용할 클래스
	
	// 0. 접속자 명단
	public static Map<Session, String> clients = new Hashtable<>();	// 동기화 [ 한명씩처리]
	
	// 1. 소켓 오픈
	@OnOpen
	public void OnOpen(Session session , @PathParam("mid") String mid ){
		try {
											// @PathParam : URL 경로상의 변수
			clients.put(session,mid);
			// 1. 모든 세션의 접속된 아이디를 json형으로 변환
			JSONArray jsonArray = new JSONArray();
			for(Session s : clients.keySet()) {	
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("type", "2");
				jsonObject.put("mid", clients.get(s));
							// Map객체.keyset() : map 객체내 모든 키 호출
							// Map객체.get(키) : map 객체내 해당 키에 해당하는 값 호출
				jsonArray.put(jsonObject);
			}
			// 2. 전송
			for(Session s : clients.keySet()) {	// 리스트에 존재하는 세션들에게 메세지 보내기
				s.getBasicRemote().sendText(jsonArray.toString());
			}
		}catch(Exception e) {e.printStackTrace();}
	}
	
	// 2. 소켓 닫기
	@OnClose
	public void OnClose(Session session, @PathParam("mid") String mid) {
		clients.remove(session);	// 해당 세션 제거
		try {
			// 1. 모든 세션의 접속된 아이디를 json형으로 변환
			JSONArray jsonArray = new JSONArray();
			for(Session s : clients.keySet()) {	
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("type", "2");
				jsonObject.put("mid", clients.get(s));
				// Map객체.keyset() : map 객체내 모든 키 호출
				// Map객체.get(키) : map 객체내 해당 키에 해당하는 값 호출
				jsonArray.put(jsonObject);
			}
			// 2. 전송
			for(Session s : clients.keySet()) {	// 리스트에 존재하는 세션들에게 메세지 보내기
				s.getBasicRemote().sendText(jsonArray.toString());
			}
		}catch(Exception e) {e.printStackTrace();}
		
		
		
		
	}
	
	// 3. 소켓 메세지 보내기
	@OnMessage
	public void OnMessage(String msg, Session session) throws Exception {
		System.out.println(session+ " 님이 보낸 메세지 : "+msg);
		for(Session s : clients.keySet()) {	// 리스트에 존재하는 세션들에게 메세지 보내기
			s.getBasicRemote().sendText(msg);
		}
	}
	
}
