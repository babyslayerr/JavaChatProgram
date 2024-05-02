import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerEx {
    public static void main(String[] args) throws IOException {
        // 접속을 기다리는 서버 소켓 생성
        ServerSocket serverSocket = new ServerSocket(9999);
        // 서버소켓의 접속대기중을 알리는 코드
        System.out.println("클라이언트 접속 대기중.....");
        // 서버소켓의 클라이언트 소켓이 접속되면 그 전담 소켓이 하나 생성된다.
        Socket listen = serverSocket.accept();
        // 접속완료
        System.out.println("접속완료! 채팅프로그램 실행");
        // InputStreamReader의 기본 디코딩 형식은 UTF-16이므로 실제 콘솔에서 실행하기 때문에 UTF-8로 맞춰준다.
        BufferedReader in = new BufferedReader(new InputStreamReader(listen.getInputStream(),"UTF-8"));
        // 마찬가지로 Writer도 UTF-8로 맞춘다.
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(listen.getOutputStream(),"UTF-8"));
        Scanner scanner = new Scanner(System.in);
        while(true){
            String inputMsg = in.readLine();
            if(inputMsg.equals("q!")){
                break;
            }
            System.out.println(inputMsg);
            System.out.println("입력 >>>");
            out.write(scanner.nextLine() + "\n");
            out.flush();
        }

        listen.close();
        serverSocket.close();

    }
}
