import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientEx {

    public static void main(String[] args) throws IOException {
        // 서버와의 통신접속을 위한 준비
        Socket clientSocket = new Socket("192.168.0.106",9999); // 서버 실행시 접속할 서버 인자를 받는다.
        // 클라이언트의 로컬호스트의 주소를 출력한다.
        System.out.println(clientSocket.getLocalAddress().getHostAddress());
        //서버로부터 문자열을 입력받는 스트림을 생성한다.
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        //서버로 문자열을 보낼 스트림을 생성한다
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        // 키보드로부터 입력을 받을 Scanner 객체를 생성한다
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("입력 >>>");
            String outputMsg = scanner.nextLine();
            out.write(outputMsg + "\n");
            out.flush();
            if(outputMsg.equals("q!")){
                break;
            }
            String serverMsg = in.readLine();
            System.out.println(serverMsg);
        }


        clientSocket.close();

    }

}
