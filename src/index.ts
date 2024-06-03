let a:number = 3;
a = 1;
let b:string = "hi";
// b = true;

let c:any = 4;
c = "333";

let d:number | string="aaaa";
d = null;

let e:string[] = ['apple','mango'];
e.push("3");

function addNumber(a:number,b:number):number{
  return a+b;
}


addNumber(3,2);