function introduce(name,age,nationality = '한국'){
    console.log(`제 이름은 ${name}입니다`);
    console.log(`나이는 ${age}이고, `);
    console.log(`국적은 ${nationality}입니다`);
}

introduce(`코드잇`, 4, '미국');
//제이름은 코드잇이고 
//나이는 4이고, 국적은 미국입니다,
console.log('');
introduce('코드잇', 4);
//제이름은 코드잇이고 
//나이는 4이고, 국적은 한국입니다,
//자동입력됩니다.

/**
 * ★옵셔녈파라미터는
 *  function introduce(name,age,nationality = '한국'){
에서 national='한국' 처럼 사용하면되는데
이것은 파라미터중 가장 마지막에 작성해줘야함

틀린예) function introduce(name,nationality = '한국',age)
**/

//예제

function orderSetMenu(sandwich, drink='스프라이트'){
    console.log(`주문하신 ${sandwich}, ${drink} 세트메뉴 나왔습니다!`)
  }
  
  // 테스트 코드
  orderSetMenu('코드웨잇 클럽');
  orderSetMenu('터키베이컨 아보카도', '코카콜라');
  orderSetMenu('코드웨잇 멜트');
  orderSetMenu('이탈리안 비엠티', '닥터페퍼');
  orderSetMenu('에그마요', '환타 오렌지');