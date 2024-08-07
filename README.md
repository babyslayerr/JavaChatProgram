# JAVA LIVE CHAT 프로젝트
자바로 작성된 간단한 콘솔형 전이중 통신 프로젝트 입니다.

## 프로젝트 구조
- `Server.java` : 서버가 사용하는 프로그램 파일이며, 클라이언트의 소켓 설정 연결을 대기합니다.
- `Client.java` : 클라이언트가 사용하는 프로그램 파일이며, 접속할 IP를 파라미터로 주어 서버로 연결을 시도합니다.

## 시작하기

### 필요조건 
- Java Development Kit (JDK) 17 이상
- windows 운영체제

### 실행화면

![chatAnimation](https://github.com/user-attachments/assets/17be3a88-1bd4-4a54-a257-87ece3f0edef)

### 실행하기 
1. **서버 실행** :
``` bash
start ServerStart.bat
```
3. **클라이언트 실행** :
``` bash
start ClientStart.bat
```

### 서버측 접속 확인
1. **접속 대기** :
```
클라이언트 접속 대기중.....
```
2. **접속 완료** :
```
접속완료! 채팅프로그램 실행
```

### 수정사항
- 하나의 스레를 사용한 단방향 통신을 다중의 스레드를 사용함으로서 전이중 통신으로 리팩토링
