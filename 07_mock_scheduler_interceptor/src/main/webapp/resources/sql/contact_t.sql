ES8에서 도입된 async와 await

async 키워드
1. 비동기 함수를 만드는 키워드
2. 함수 앞에 추가
async function함수이름(){}
async function(){}
async ()=>{}
const 함수이름 = async function(){}
const 함수이름 = async ()=>{}
async 함수는 항상 Promise를 반환한다.

await 키워드
1. Promise 이행을 기다리기 위해서 사용한다.
2. 오직 async 함수 내부에서만 사용할 수 있다.
3. 형식
value = await expression