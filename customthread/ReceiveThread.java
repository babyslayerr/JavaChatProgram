package customthread;

import jdk.jfr.consumer.RecordedEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ReceiveThread extends Thread{

    private ServerSocket serverSocket;
    private Socket clientSocket;

    private BufferedReader in;

    public ReceiveThread( BufferedReader in){
        this.in = in;
    }
    public ReceiveThread(ServerSocket serverSocket, Socket clientSocket, BufferedReader in){
        this.serverSocket = serverSocket;
        this.clientSocket = clientSocket;
        this.in = in;
    }

    @Override
    public void run(){
        while(true){
            try {
                // inputStream에서 한줄씩 받는다.
                String receiveWord = in.readLine();
                // q!가 들어오면 반복문을 종료한다.
                if(receiveWord.equals("q!")){
                    if(serverSocket!=null)serverSocket.close();
                    if(clientSocket!=null)clientSocket.close();
                    break;
                }
                // 입력받은 문자열을 출력한다.
                System.out.println(receiveWord);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
