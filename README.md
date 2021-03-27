# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 구현기능 목록
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
* 로또 1장의 가격은 1000원이다.

## 구현 객체

* Domain   
  * LottoNumber   
    * 로또 번호 생성자(1~45 까지의 숫자)   
  * Lotto   
    * 로또 1회 생성자(6개의 LottoNumber를 갖고 있음)   
    * 당첨결과(param : WinningNumbers, return : Rank)   
  * Lottos   
    * 로또 n회 생성자(n = 구매금액 / 로또 가격)   
    * 구매금액   
    * 당첨결과(param :WinningNumbers, return : List<Rank>)   
    * 수익률
  * WinningNumber   
    * 게임 당첨 번호 생성자(input된 당첨 번호)   
    * getWinningNumbers(return : 게임 당첨 번호)
  * Rank(enum)   
    * 형식 : 등수(int matchCount, int winningMoney)
    * 당첨등수 생성자(param : matchCount)   
  

* module
  * Game(interface)
    * generate   
    * getWinner   
    * getYield   
  * LottoGame implments Game
    * generate
    * getWinner
    * getYield  
  * Statistics   
    * 당첨 통계(6개일치,5개일치,4개일치,3개일치,2개일치)   
    * 수익률   

* ui   
  * InputView   
    * 구입금액
    * 당첨번호
  * ResultView   
    * 당첨 통계 결과
    * 수익률 결과

* controller   
  * LottoMain   
    * run   


## 구현예시
```
구입금액을 입력해 주세요.
14000
14개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[23, 25, 33, 36, 39, 41]
[1, 3, 5, 14, 22, 45]
[5, 9, 38, 41, 43, 44]
[2, 8, 9, 18, 19, 21]
[13, 14, 18, 21, 23, 35]
[17, 21, 29, 37, 42, 45]
[3, 8, 27, 30, 35, 44]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
6개 일치 (2000000000원)- 0개
총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
```
