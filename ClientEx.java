import Test.EmojiTest;
import customthread.ReceiveThread;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientEx {

    public static void main(String[] args) throws IOException {
        System.out.println(EmojiTest.getEmoji());
        // 서버와의 통신접속을 위한 준비
        // Socket clientSocket = new Socket("",9999); // 서버 실행시 접속할 서버 인자를 받는다.
        //Test용
        Socket clientSocket = new Socket("127.0.0.1",9999); // 서버 실행시 접속할 서버 인자를 받는다.
        // 클라이언트의 로컬호스트의 주소를 출력한다.
        System.out.println(clientSocket.getLocalAddress().getHostAddress());
        //서버로부터 문자열을 입력받는 스트림을 생성한다.(디코딩 형식을 UTF-8로 맞춘다)
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(),"UTF-8"));
        // 수신 전용 스레드 생성 및 시작
        ReceiveThread receiveThread = new ReceiveThread(in);
        receiveThread.start();
        //서버로 문자열을 보낼 스트림을 생성한다(인코딩 형식을 UTF-8로 맞춘다.)
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream(),"UTF-8"));
        // 키보드로부터 입력을 받을 Scanner 객체를 생성한다
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("입력 >>>" + EmojiEx.getEmoji1());
            String outputMsg = scanner.nextLine();
            out.write(outputMsg + "\n");
            out.flush();
            if(outputMsg.equals("q!")){
                break;
            }
        }
        clientSocket.close();
    }

}
