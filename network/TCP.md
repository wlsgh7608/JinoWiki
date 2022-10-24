# TCP(Transmission Control Protocol)

<img src="https://user-images.githubusercontent.com/62232531/197543840-232815da-9dc2-47a8-8030-5911e71be725.png">

### [ 전송 단위 ]

- **Segment**

### [ TCP 특징 ]

- **연결형** 서비스로 가상 회선 방식을 제공한다.
- `3-way handshaking`을 통해 연결을 설정,`4-way handshaking`을 통해 해제
- **흐름 제어** 및 **혼잡 제어**.
- **높은 신뢰성**을 보장
- **UDP**보다 속도가 느리다.
- **Point to Point** : 하나의 송신 측과 하나의 수신 측이 통신하는 1:1 통신
- **Full-Duplex :** 전송이 양방향

<aside>
💡 **흐름제어** , **혼잡제어
흐름 제어(Flow Control) - 수신자의 `receive buffer`**의 `accesible space` 만큼 전송

**혼잡 제어(Congestion Control) - 네트워크**가 \*\*\*\*혼잡해지지 않도록 조절하며 데이터를 전송

</aside>

<aside>
💡 **연결형? 비연결형?**
**연결형**(**connection-oriented service)** - 신뢰할 수 있고 정확한 데이터를 전달하는 통신. 따라서 통신하고자 하는 상대와 **확인**하는 과정(`3-way handshaking`)이 필요하다.

**비연결형**(**connectionless service) -**효율적으로 데이터를 전달하는 통신. 통신하고자 하는 상대와 확인하지 않고, **일방적**으로 데이터를 전송한다.

</aside>

### [ TCP 헤더 ]

<img src="https://user-images.githubusercontent.com/62232531/197543957-09c91c09-e95b-4a78-969c-101a8bccad9c.png">

헤더의 크기는 20바이트 ~ 60바이트

- **Source port - 출발지의 포트번호**
- **Destination port - 목적지의 포트번호**
- **Sequence Number** - 전송하는 데이터의 번호
- **Acknowledgement number** - 데이터를 받은 receiver가 예상하는 다음 시퀀스 번호
- **Data Offset** - 세그먼트 중 데이터가 시작되는 위치
- **Reversed** - 미래를 위해 예약된 필드
- **Flags** - SYN, ACK, FIN
- **Window Size** - 한번에 정송할 수 있는 데이터의 양
- **Checksum** - 데이터 송신하는 중 발생하는 오류 검출
- **Urgent Pointer** - 긴급 포인터( Flags의 URG 가 1이라면 이 데이터를 우선처리)
- **Options** - TCP 기능을 확장할 때 사용하는 필드

### 흐름제어(Flow Control) - receiver 상황 고려

<img src="https://user-images.githubusercontent.com/62232531/197544049-25f899b6-c3af-42f8-8b5b-18cb5cc9d9a6.png">

receive buffer

`**receive buffer**`의 `accesible space`만큼 전송해야 한다.

### ❓ receive buffer의 accesible space은 어떻게 알 수 있을까?

### ✅ TCP segment의 `헤더(Receive window)`에 담겨 있다.

<img src="https://user-images.githubusercontent.com/62232531/197544081-496fcb11-a7cb-4fe5-bf7f-feace93416e5.png">

### 혼잡제어(Congestion Control) - 네트워크 상황 고려

### TCP 전송 속도

<img src="https://user-images.githubusercontent.com/62232531/197544256-b97edd2e-ebf8-4d14-be8e-bffe1bd16c71.png">

1. **Slow start**
   1. 한방울씩 늘리는 것 보다는 $2^n$의 exponential로 늘림
2. **Addictive increase**
   1. `threshold` 이후에는 조심조심 linear하게 늘림(`패킷로스`가 발생할 때 까지)
3. **multiplicative decrease**
   1. `패킷로스` 가 발생한다면 속도를 1/2로 떨어뜨리는 것을 이른다.

### [ 단점 ]

- `3-way handshake`connenction은 통신할 때마다 일어나기 때문에 시간 손실
- 패킷에 대한 응답을 해야하기 때문에(시간 지연, CPU 소모) 성능이 낮다.

### [ TCP Flow ]

<img src="https://user-images.githubusercontent.com/62232531/197544510-5d824f50-6586-4674-bbee-6e580d2dd568.png">
