# 2022.07 ~ 알고리즘 문제 분류

# 유형

- 기초 문제
- 완전 탐색
- 자료 구조
  - 스택
  - 큐
  - 리스트
  - 우선순위 큐
  - 데크
- 그리디
- 재귀
- 그래프 탐색
  - bfs & dfs
  - 다익스트라
  - 플로이드 워셜
- MST
  - union & find
  - prim
- 구현 & 시뮬레이션
- dp

- 기타
  - 백트래킹
  - 비트마스킹
  - 문자열
  - 슬라이딩 윈도우
  - 소수 판별
  - 2차원 배열 회전

<br>
<br>

## 기초 문제

|  ☆  |  #  | Problem                                                                                                                         | Note | Code                                                                                                                                                                                     |
| :-: | :-: | :------------------------------------------------------------------------------------------------------------------------------ | :--: | :--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|     | 01  | [SWEA1289\_원재의메모리복구하기](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV19AcoKI9sCFAZN) |      | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P001_SWEA1289_%EC%9B%90%EC%9E%AC%EC%9D%98%EB%A9%94%EB%AA%A8%EB%A6%AC%EB%B3%B5%EA%B5%AC%ED%95%98%EA%B8%B0.java) |
|     | 02  | [BJ1244\_스위치켜고끄기](https://www.acmicpc.net/problem/1244)                                                                  |      | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P003_BJ1244_%EC%8A%A4%EC%9C%84%EC%B9%98%EC%BC%9C%EA%B3%A0%EB%81%84%EA%B8%B0.java)                              |
|     | 03  | [SWEA2805\_농작물수확하기](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GLXqKAWYDFAXB)       |      | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P006_SWEA2805_%EB%86%8D%EC%9E%91%EB%AC%BC%EC%88%98%ED%99%95%ED%95%98%EA%B8%B0.java)                            |
|     | 04  | [BJ2563\_색종이](https://www.acmicpc.net/problem/2563)                                                                          |      | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P024_BJ2563_%EC%83%89%EC%A2%85%EC%9D%B4.java)                                                                  |

<br>
<br>

## 완전 탐색

|  ☆  |  #  | Problem                                                                                                                             |    Note     | Code                                                                                                                                                                                                       |
| :-: | :-: | :---------------------------------------------------------------------------------------------------------------------------------- | :---------: | :--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|     | 01  | [BJ2023\_신기한소수](https://www.acmicpc.net/problem/2023)                                                                          |    조합     | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P016_BJ2023_%EC%8B%A0%EA%B8%B0%ED%95%9C%EC%86%8C%EC%88%98.java)                                                                  |
|     | 02  | [SWEA9229\_한빈이와SpotMart](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW8Wj7cqbY0DFAXN)         |             | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P020_SWEA9229_%ED%95%9C%EB%B9%88%EC%9D%B4%EC%99%80SpotMart.java)                                                                 |
|     | 03  | [SWEA6808\_규영이와인영이의카드게임](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWgv9va6HnkDFAW0) |    순열     | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P022_SWEA6808_%EA%B7%9C%EC%98%81%EC%9D%B4%EC%99%80%EC%9D%B8%EC%98%81%EC%9D%B4%EC%9D%98%EC%B9%B4%EB%93%9C%EA%B2%8C%EC%9E%84.java) |
|     | 04  | [BJ2961\_도영이가만든맛있는음식](https://www.acmicpc.net/problem/2961)                                                              |  부분조합   | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P030_BJ2961_%EB%8F%84%EC%98%81%EC%9D%B4%EA%B0%80%EB%A7%8C%EB%93%A0%EB%A7%9B%EC%9E%88%EB%8A%94%EC%9D%8C%EC%8B%9D.java)            |
|     | 05  | [BJ3040\_백설공주와일곱난쟁이](https://www.acmicpc.net/problem/3040)                                                                |    조합     | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P031_BJ3040_%EB%B0%B1%EC%84%A4%EA%B3%B5%EC%A3%BC%EC%99%80%EC%9D%BC%EA%B3%B1%EB%82%9C%EC%9F%81%EC%9D%B4.java)                     |
|  ★  | 06  | [BJ15686치킨배달](https://www.acmicpc.net/problem/15686)                                                                            |    조합     | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P032_BJ15686%EC%B9%98%ED%82%A8%EB%B0%B0%EB%8B%AC.java)                                                                           |
|     | 07  | [SWEA4012\_요리사](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeUtVakTMDFAVH)                   | 조합+빡구현 | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P034_SWEA4012_%EC%9A%94%EB%A6%AC%EC%82%AC.java)                                                                                  |
|     | 08  | [SWEA1247\_최적경로](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15OZ4qAPICFAYD)                 |    순열     | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P043_SWEA1247_%EC%B5%9C%EC%A0%81%EA%B2%BD%EB%A1%9C.java)                                                                         |
|     | 09  | [SWEA3234\_준환이의양팔저울](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWAe7XSKfUUDFAUw)         |    순열     | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P046_SWEA3234_%EC%A4%80%ED%99%98%EC%9D%B4%EC%9D%98%EC%96%91%ED%8C%94%EC%A0%80%EC%9A%B8.java)                                     |
|  ★  | 10  | [BJ17135\_캐슬디펜스](https://www.acmicpc.net/problem/17135)                                                                        | 조합+빡구현 | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P047_BJ17135_%EC%BA%90%EC%8A%AC%EB%94%94%ED%8E%9C%EC%8A%A4.java)                                                                 |
|     | 11  | [BJ10971\_외판원순회2](https://www.acmicpc.net/problem/10971)                                                                       |             | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P060_BJ10971_%EC%99%B8%ED%8C%90%EC%9B%90%EC%88%9C%ED%9A%8C2.java)                                                                |

<br>
<br>

## 자료구조

|  ☆  |  #  | Problem                                                                                                                       |    Note     | Code                                                                                                                                                                            |
| :-: | :-: | :---------------------------------------------------------------------------------------------------------------------------- | :---------: | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
|     | 01  | [SWEA1218\_괄호짝짓기](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14eWb6AAkCFAYD)         |    스택     | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P012_SWEA1218_%EA%B4%84%ED%98%B8%EC%A7%9D%EC%A7%93%EA%B8%B0.java)                                     |
|     | 02  | [SWEA1225\_암호생성기](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14uWl6AF0CFAYD)         |     큐      | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P013_SWEA1225_%EC%95%94%ED%98%B8%EC%83%9D%EC%84%B1%EA%B8%B0.java)                                     |
|     | 03  | [BJ2164\_카드2](https://www.acmicpc.net/problem/2164)                                                                         |     큐      | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P014_BJ2164_%EC%B9%B4%EB%93%9C2.java)                                                                 |
|     | 04  | [BJ2493\_탑](https://www.acmicpc.net/problem/2493)                                                                            |    스택     | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P017_BJ2493_%ED%83%91.java)                                                                           |
|     | 05  | [SWEA1228\_암호문1](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14w-rKAHACFAYD)            |   리스트    | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P018_SWEA1228_%EC%95%94%ED%98%B8%EB%AC%B81.java)                                                      |
|     | 06  | [BJ1158\_요세푸스문제](https://www.acmicpc.net/problem/1158)                                                                  |     큐      | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P019_BJ1158_%EC%9A%94%EC%84%B8%ED%91%B8%EC%8A%A4%EB%AC%B8%EC%A0%9C.java)                              |
|     | 07  | [SWEA1233\_사칙연산유효성검사](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV141176AIwCFAYD) |     큐      | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P021_SWEA1233_%EC%82%AC%EC%B9%99%EC%97%B0%EC%82%B0%EC%9C%A0%ED%9A%A8%EC%84%B1%EA%B2%80%EC%82%AC.java) |
|     | 08  | [BJ11286\_절댓값힙](https://www.acmicpc.net/problem/11286)                                                                    | 우선순위 큐 | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P033_BJ11286_%EC%A0%88%EB%8C%93%EA%B0%92%ED%9E%99.java)                                               |
|     | 08  | [SWEA_4013\_특이한자석](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeV9sKkcoDFAVH)        |    데크     | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P063_SWEA_4013_%ED%8A%B9%EC%9D%B4%ED%95%9C%EC%9E%90%EC%84%9D.java)                                    |

<br>

### 그리디

|  ☆  |  #  | Problem                                                                                                           | Note | Code                                                                                                                    |
| :-: | :-: | :---------------------------------------------------------------------------------------------------------------- | :--: | :---------------------------------------------------------------------------------------------------------------------- |
|     | 01  | [SWEA1208_Flatten](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV139KOaABgCFAYh) |      | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P004_SWEA1208_Flatten.java)                   |
|     | 02  | [BJ10828\_냉장고](http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&code=1828&sca=3050)                        |      | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P037_JO1828_%EB%83%89%EC%9E%A5%EA%B3%A0.java) |

<br>

### 재귀

|  ☆  |  #  | Problem                                                            | Note | Code                                                                                                                                                                  |
| :-: | :-: | :----------------------------------------------------------------- | :--: | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|     | 01  | [BJ17478\_재귀함수가뭔가요](https://www.acmicpc.net/problem/17478) |      | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P002_BJ17478_%EC%9E%AC%EA%B7%80%ED%95%A8%EC%88%98%EA%B0%80%EB%AD%94%EA%B0%80%EC%9A%94.java) |
|     | 02  | [BJ1074_Z](https://www.acmicpc.net/problem/1074)                   |      | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P036_BJ1074_Z.java)                                                                         |
|     | 03  | [BJ1992\_쿼드트리](https://www.acmicpc.net/problem/1992)           |      | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P041_BJ1992_%EC%BF%BC%EB%93%9C%ED%8A%B8%EB%A6%AC.java)                                      |

<br>

# 그래프 탐색

## bfs & dfs

|  ☆  |  #  | Problem                                                                                                                       | Note | Code                                                                                                                                                                                   |
| :-: | :-: | :---------------------------------------------------------------------------------------------------------------------------- | :--: | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|     | 01  | [SWEA1861\_정사각형방](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LtJYKDzsDFAXc)         |      | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P023_SWEA1861_%EC%A0%95%EC%82%AC%EA%B0%81%ED%98%95%EB%B0%A9.java)                                            |
|  ★  | 02  | [BJ15683\_감시](https://www.acmicpc.net/problem/15683)                                                                        | dfs  | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P040_BJ15683_%EA%B0%90%EC%8B%9C.java)                                                                        |
|     | 03  | [BJ3109\_빵집](https://www.acmicpc.net/problem/3109)                                                                          | dfs  | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P042_BJ3109_%EB%B9%B5%EC%A7%91.java)                                                                         |
|     | 04  | [BJ1987\_알파벳](https://www.acmicpc.net/problem/1987)                                                                        |      | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P044_BJ1987_%EC%95%8C%ED%8C%8C%EB%B2%B3.java)                                                                |
|     | 05  | [BJ1260_DFS와BFS](https://www.acmicpc.net/problem/1260)                                                                       |      | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P045_BJ1260_DFS%EC%99%80BFS.java)                                                                            |
|     | 06  | [BJ1697\_숨바꼭질](https://www.acmicpc.net/problem/1697)                                                                      | bfs  | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P048_BJ1697_%EC%88%A8%EB%B0%94%EA%BC%AD%EC%A7%88.java)                                                       |
|     | 07  | [SWEA1238_Contact](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15B1cKAKwCFAYD)             |      | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P049_SWEA1238_Contact.java)                                                                                  |
|     | 08  | [BJ13023_ABCDE](https://www.acmicpc.net/problem/13023)                                                                        | dfs  | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P050_BJ13023_ABCDE.java)                                                                                     |
|     | 09  | [SWEA7465\_창용마을무리의개수](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWngfZVa9XwDFAQU) |      | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P053_SWEA7465_%EC%B0%BD%EC%9A%A9%EB%A7%88%EC%9D%84%EB%AC%B4%EB%A6%AC%EC%9D%98%EA%B0%9C%EC%88%98.java)        |
|     | 10  | [BJ13055\_탈출](https://www.acmicpc.net/problem/13055)                                                                        |      | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P054_BJ13055_%ED%83%88%EC%B6%9C.java)                                                                        |
|     | 11  | [BJ16236\_아기상어](https://www.acmicpc.net/problem/16236)                                                                    |      | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P055_BJ16236_%EC%95%84%EA%B8%B0%EC%83%81%EC%96%B4.java)                                                      |
|     | 12  | [BJ7576\_토마토](https://www.acmicpc.net/problem/7576)                                                                        |      | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P056_BJ7576_%ED%86%A0%EB%A7%88%ED%86%A0.java)                                                                |
|     | 13  | [BJ10026\_적록색약](https://www.acmicpc.net/problem/10026)                                                                    |      | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P057_BJ10026_%EC%A0%81%EB%A1%9D%EC%83%89%EC%95%BD.java)                                                      |
|  ★  | 14  | [BJ1600\_말이되고픈원숭이](https://www.acmicpc.net/problem/1600)                                                              |      | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P067_BJ1600_%EB%A7%90%EC%9D%B4%EB%90%98%EA%B3%A0%ED%94%88%EC%9B%90%EC%88%AD%EC%9D%B4.java)                   |
|     | 15  | [BJ2636\_치즈](https://www.acmicpc.net/problem/2636)                                                                          |      | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P075_BJ2636_%EC%B9%98%EC%A6%88.java)                                                                         |
|     | 16  | [BJ9205\_맥주마시면서걸어가기](https://www.acmicpc.net/problem/9205)                                                          |      | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P078_BJ9205_%EB%A7%A5%EC%A3%BC%EB%A7%88%EC%8B%9C%EB%A9%B4%EC%84%9C%EA%B1%B8%EC%96%B4%EA%B0%80%EA%B8%B0.java) |

<br>

## dijkstra

|  ☆  |  #  | Problem                                                                                                           | Note | Code                                                                                                                                                                                                                                 |
| :-: | :-: | :---------------------------------------------------------------------------------------------------------------- | :--: | :----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|     | 01  | [BJ4485\_녹색옷입은애가젤다지\_다익스트라](https://www.acmicpc.net/problem/4485)                                  |      | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P061_BJ4485_%EB%85%B9%EC%83%89%EC%98%B7%EC%9E%85%EC%9D%80%EC%95%A0%EA%B0%80%EC%A0%A4%EB%8B%A4%EC%A7%80_%EB%8B%A4%EC%9D%B5%EC%8A%A4%ED%8A%B8%EB%9D%BC.java) |
|     | 02  | [SWEA1249\_보급로](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15QRX6APsCFAYD) |      | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P068_SWEA1249_%EB%B3%B4%EA%B8%89%EB%A1%9C.java)                                                                                                            |

<br>

### 플로이드 워셜

|  ☆  |  #  | Problem                                                                                                           | Note | Code                                                                                                                                                                                         |
| :-: | :-: | :---------------------------------------------------------------------------------------------------------------- | :--: | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|     | 01  | [BJ9205\_맥주마시면서걸어가기](https://www.acmicpc.net/problem/9205)                                              |      | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P078_BJ9205_%EB%A7%A5%EC%A3%BC%EB%A7%88%EC%8B%9C%EB%A9%B4%EC%84%9C%EA%B1%B8%EC%96%B4%EA%B0%80%EA%B8%B0_floyd.java) |
|     | 02  | [SWEA5643\_키순서](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXQsLWKd5cDFAUo) |      | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P081_SWEA5643_%ED%82%A4%EC%88%9C%EC%84%9C.java)                                                                    |

<br>
<br>

# MST

## unionFind

|  ☆  |  #  | Problem                                                                                                                   | Note | Code                                                                                                                                                          |
| :-: | :-: | :------------------------------------------------------------------------------------------------------------------------ | :--: | :------------------------------------------------------------------------------------------------------------------------------------------------------------ |
|     | 01  | [SWEA3289\_서로소집합](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBJKA6qr2oDFAWr)     |      | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P051_SWEA3289_%EC%84%9C%EB%A1%9C%EC%86%8C%EC%A7%91%ED%95%A9.java)                   |
|     | 02  | [SWEA3124\_최소스패닝트리](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV_mSnmKUckDFAWb) |      | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P052_SWEA3124_%EC%B5%9C%EC%86%8C%EC%8A%A4%ED%8C%A8%EB%8B%9D%ED%8A%B8%EB%A6%AC.java) |

## Prim

|  ☆  |  #  | Problem                                                                                                                           | Note | Code                                                                                                                                                                                      |
| :-: | :-: | :-------------------------------------------------------------------------------------------------------------------------------- | :--: | :---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|     | 01  | [SWEA3289\_서로소집합](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV19AcoKI9sCFAZN)             |      | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P051_SWEA3289_%EC%84%9C%EB%A1%9C%EC%86%8C%EC%A7%91%ED%95%A9.java)                                               |
|     | 02  | [SWEA1251\_하나로\_프림인접행렬](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15StKqAQkCFAYD)   |      | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P059_SWEA1251_%ED%95%98%EB%82%98%EB%A1%9C_%ED%94%84%EB%A6%BC%EC%9D%B8%EC%A0%91%ED%96%89%EB%A0%AC.java)          |
|     | 02  | [SWEA1251\_하나로\_프림인접리스트](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15StKqAQkCFAYD) |      | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P058_SWEA1251_%ED%95%98%EB%82%98%EB%A1%9C_%ED%94%84%EB%A6%BC%EC%9D%B8%EC%A0%91%EB%A6%AC%EC%8A%A4%ED%8A%B8.java) |

<br> 
<br>

## 구현 / 시뮬레이션

|  ☆  |  #  | Problem                                                                                                                   |      Note      | Code                                                                                                                                                                 |
| :-: | :-: | :------------------------------------------------------------------------------------------------------------------------ | :------------: | :------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|     | 01  | [SWEA1210_Ladder1](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14ABYKADACFAYh)         |                | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P005_SWEA1210_Ladder1.java)                                                                |
|     | 02  | [SWEA1954\_달팽이숫자](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PobmqAPoDFAUq)     |                | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P007_SWEA1954_%EB%8B%AC%ED%8C%BD%EC%9D%B4%EC%88%AB%EC%9E%90.java)                          |
|     | 03  | [SWEA1873\_상호의배틀필드](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LyE7KD2ADFAXc) |     빡구현     | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P008_SWEA1873_%EC%83%81%ED%98%B8%EC%9D%98%EB%B0%B0%ED%8B%80%ED%95%84%EB%93%9C.java)        |
|  ★  | 04  | [BJ17406\_배열돌리기4](https://www.acmicpc.net/problem/17406)                                                             |     빡구현     | [Java Code](https://github.com/wlsgh7608/JinoWiki/algorithm/src/)                                                                                                    |
|     | 05  | [SWEA4012\_요리사](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeUtVakTMDFAVH)         |  조합+빡구현   | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P034_SWEA4012_%EC%9A%94%EB%A6%AC%EC%82%AC.java)                                            |
|     | 06  | [SWEA5644\_무선충전](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRDL1aeugDFAUo)       |  조합+빡구현   | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P038_SWEA5644_%EB%AC%B4%EC%84%A0%EC%B6%A9%EC%A0%84.java)                                   |
|  ★  | 07  | [BJ17135\_캐슬디펜스](https://www.acmicpc.net/problem/17135)                                                              |  조합+빡구현   | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P047_BJ17135_%EC%BA%90%EC%8A%AC%EB%94%94%ED%8E%9C%EC%8A%A4.java)                           |
|  ★  | 08  | [BJ16236\_아기상어](https://www.acmicpc.net/problem/16236)                                                                |     빡구현     | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P055_BJ16236_%EC%95%84%EA%B8%B0%EC%83%81%EC%96%B4.java)                                    |
|  ★  | 09  | [BJ17144\_미세먼지안녕](https://www.acmicpc.net/problem/17144)                                                            |                | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P062_BJ17144_%EB%AF%B8%EC%84%B8%EB%A8%BC%EC%A7%80%EC%95%88%EB%85%95.java)                  |
|     | 10  | [BJ17143\_낚시왕](https://www.acmicpc.net/problem/17143)                                                                  | 빡구현(어려움) | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P073_BJ17143_%EB%82%9A%EC%8B%9C%EC%99%95.java)                                             |
|     | 11  | [BJ1194\_달이차오른다가자](https://www.acmicpc.net/problem/1194)                                                          |   비트마스킹   | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P074_BJ1194_%EB%8B%AC%EC%9D%B4%EC%B0%A8%EC%98%A4%EB%A5%B8%EB%8B%A4%EA%B0%80%EC%9E%90.java) |

<br>

## DP

|  ☆  |  #  | Problem                                                                                                                     |    Note    | Code                                                                                                                                                                   |
| :-: | :-: | :-------------------------------------------------------------------------------------------------------------------------- | :--------: | :--------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|     | 01  | [BJ11659\_구간합구하기4](https://www.acmicpc.net/problem/11659)                                                             | Prefix Sum | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P009_BJ11659_%EA%B5%AC%EA%B0%84%ED%95%A9%EA%B5%AC%ED%95%98%EA%B8%B04.java)                   |
|     | 02  | [BJ11660\_구간합구하기5](https://www.acmicpc.net/problem/11660)                                                             | Prefix Sum | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P010_BJ11660_%EA%B5%AC%EA%B0%84%ED%95%A9%EA%B5%AC%ED%95%98%EA%B8%B05.java)                   |
|     | 03  | [SWEA2001\_파리퇴치](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PzOCKAigDFAUq)         | Prefix Sum | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P011_SWEA2001_%ED%8C%8C%EB%A6%AC%ED%87%B4%EC%B9%98.java)                                     |
|     | 04  | [BJ1010\_다리놓기](https://www.acmicpc.net/problem/1010)                                                                    |            | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P027_BJ1010_%EB%8B%A4%EB%A6%AC%EB%86%93%EA%B8%B0.java)                                       |
|     | 05  | [SWEA5215\_햄버거다이어트](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWT-lPB6dHUDFAVT)   |            | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P029_SWEA5215_%ED%96%84%EB%B2%84%EA%B1%B0%EB%8B%A4%EC%9D%B4%EC%96%B4%ED%8A%B8.java)          |
|     | 06  | [BJ2839\_설탕배달](https://www.acmicpc.net/problem/2839)                                                                    |            | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P035_BJ2839_%EC%84%A4%ED%83%95%EB%B0%B0%EB%8B%AC.java)                                       |
|     | 07  | [BJ1463_1로만들기](https://www.acmicpc.net/problem/1463)                                                                    |            | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P064_BJ1463_1%EB%A1%9C%EB%A7%8C%EB%93%A4%EA%B8%B0.java)                                      |
|     | 08  | [BJ1149_RGB거리](https://www.acmicpc.net/problem/1149)                                                                      |            | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P065_BJ1149_RGB%EA%B1%B0%EB%A6%AC.java)                                                      |
|     | 09  | [BJ17070\_파이프옮기기1](https://www.acmicpc.net/problem/17070)                                                             |            | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P066_BJ17070_%ED%8C%8C%EC%9D%B4%ED%94%84%EC%98%AE%EA%B8%B0%EA%B8%B01.java)                   |
|     | 10  | [SWEA3307\_최장증가부분수열](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBOKg-a6l0DFAWr) |            | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P076_SWEA3307_%EC%B5%9C%EC%9E%A5%EC%A6%9D%EA%B0%80%EB%B6%80%EB%B6%84%EC%88%98%EC%97%B4.java) |
|     |

<br>
<br>

# 기타

### 백트래킹

|  ☆  |  #  | Problem                                                | Note | Code                                                                                                                    |
| :-: | :-: | :----------------------------------------------------- | :--: | :---------------------------------------------------------------------------------------------------------------------- |
|  ★  | 01  | [BJ2239\_스도쿠](https://www.acmicpc.net/problem/2239) |      | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P072_BJ2239_%EC%8A%A4%EB%8F%84%EC%BF%A0.java) |

<br>

### 비트마스킹

|  ☆  |  #  | Problem                                                          |  Note  | Code                                                                                                                                                                 |
| :-: | :-: | :--------------------------------------------------------------- | :----: | :------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|  ★  | 01  | [BJ1194\_달이차오른다가자](https://www.acmicpc.net/problem/1194) | 빡구현 | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P074_BJ1194_%EB%8B%AC%EC%9D%B4%EC%B0%A8%EC%98%A4%EB%A5%B8%EB%8B%A4%EA%B0%80%EC%9E%90.java) |

<br>

### 문자열

|  ☆  |  #  | Problem                                                      | Note | Code                                                                                                                                               |
| :-: | :-: | :----------------------------------------------------------- | :--: | :------------------------------------------------------------------------------------------------------------------------------------------------- |
|     | 01  | [BJ1541\_잃어버린괄호](https://www.acmicpc.net/problem/1541) |      | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P039_BJ1541_%EC%9E%83%EC%96%B4%EB%B2%84%EB%A6%B0%EA%B4%84%ED%98%B8.java) |

<br>

### 슬라이딩 윈도우

|  ☆  |  #  | Problem                                                      | Note | Code                                                                                                                                 |
| :-: | :-: | :----------------------------------------------------------- | :--: | :----------------------------------------------------------------------------------------------------------------------------------- |
|     | 01  | [BJ12891_DNA비밀번호](https://www.acmicpc.net/problem/12891) |      | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P015_BJ12891_DNA%EB%B9%84%EB%B0%80%EB%B2%88%ED%98%B8.java) |

<br>

### 소수 판별

|  ☆  |  #  | Problem                                                    | Note | Code                                                                                                                                      |
| :-: | :-: | :--------------------------------------------------------- | :--: | :---------------------------------------------------------------------------------------------------------------------------------------- |
|     | 01  | [BJ2023\_신기한소수](https://www.acmicpc.net/problem/2023) |      | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P016_BJ2023_%EC%8B%A0%EA%B8%B0%ED%95%9C%EC%86%8C%EC%88%98.java) |

<br>

### 2차원 배열 회전 / 반전 (익숙하지 않아....)

|  ☆  |  #  | Problem                                                       |  Note  | Code                                                                                                                                        |
| :-: | :-: | :------------------------------------------------------------ | :----: | :------------------------------------------------------------------------------------------------------------------------------------------ |
|     | 01  | [BJ16926\_배열돌리기1](https://www.acmicpc.net/problem/16926) |        | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P025_BJ16926_%EB%B0%B0%EC%97%B4%EB%8F%8C%EB%A6%AC%EA%B8%B01.java) |
|     | 02  | [BJ16935\_배열돌리기3](https://www.acmicpc.net/problem/16935) |        | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P026_BJ16935_%EB%B0%B0%EC%97%B4%EB%8F%8C%EB%A6%AC%EA%B8%B03.java) |
|     | 03  | [BJ17406\_배열돌리기4](https://www.acmicpc.net/problem/17406) | 빡구현 | [Java Code](https://github.com/wlsgh7608/JinoWiki/blob/main/algorithm/src/P028_BJ17406_%EB%B0%B0%EC%97%B4%EB%8F%8C%EB%A6%AC%EA%B8%B04.java) |
