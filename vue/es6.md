## `var` , `let`, `const`

| 키워드 | 구분 | 선언위치               | 재선언 |
| ------ | ---- | ---------------------- | ------ |
| var    | 변수 | 전역 스코프(함수 레벨) | 가능   |
| let    | 변수 | 해당 스코프(블록 레벨) | 불가능 |
| const  | 상수 | 해당 스코프(블록 레벨) | 불가능 |

**`var`** : 같은 이름으로 **재선언** 및 **재할당** 가능

- 코드
  ```jsx
  // var 예약어는 똑같은 변수를 재선언할 수 있다.
  var v = 10;
  console.log(v); // 10
  var v = 20; // **재 선언 및 재할당 가능**
  console.log(v); // 20
  ```

**`let`** : 같은 이름으로 **재선언 불가** , **재할당 가능**

- 코드
  ```jsx
  // let 예약어는 한번 선언한 똑같은 변수를 재선언할 수 없다.
  let a = 10;
  console.log(a);
  a = 20;
  console.log(a);
  // let a = 2;
  // console.log(a);
  ```

`const` : **값 변경 불가능**.

- 코드
  ```jsx
  // const 예약어는 한번 할당한 값을 변경할 수 없다.
  const b = 20;
  b = 30; // Uncaught TypeError: Assignment to constant variable.
  ```

## Scope

함수 레벨 스코프 (Function-level scope)

> 함수 내에서 선언된 변수는 **함수 내에서만 유효**하며 함수 외부에서는 참조 불가.
> 함수 내부에서 선언한 변수는 지역 변수이며 **함수 외부에서 선언한 변수는 모두 전역변수**이다.

블록 레벨 스코프 (Block-level scope)

> 모든 코드 블록(함수, 제어문, 조건문, try/catch문 등) 내에서 선언된 변수는 **코드 블록 내에서만 유효**하며 블록 외부에서는 참조 불
> 가능. **코드 블록 내부에서 선언한 변수는 지역 변수**.

### var의 유효범위 : **`함수레벨`** 스코프(function-level scope)

<img src="https://user-images.githubusercontent.com/62232531/200314268-459b29a4-35b4-440d-8e4c-fa1a403ca848.png">

- 코드
  ```jsx
  var x = 100;
  function print() {
    var x = 200;
    console.log(x); // 200
    {
      var x = 300;
      console.log(x); // 300
      x = 400;
    }
    console.log(x); // 400
  }
  print();
  console.log(x); // 100
  ```

### let의 유효범위 : `블록레벨` 스코프(block-level scope)

<img src="https://user-images.githubusercontent.com/62232531/200316008-f1480135-873f-433f-a3ef-8eec5304d831.png">

- 코드
  ```jsx
  // let 의 유효범위 : 블록레벨 스코프(block-level scope)
  let y = 100;
  function print() {
    let y = 200;
    console.log(y); // 200
    {
      let y = 300;
      console.log(y); // 300
      y = 400;
    }
    console.log(y); // 200
  }
  print();
  console.log(y); // 100
  ```
