/* tests for L1 step 1 */

let x = 1;
  (x + 1);;
/* Result: 2 */

(let x = 1; (x + 1)) * (let x = 2; (x + 3))
/* Result: 10 */

let x = 1;
  let y = 2;
  (x + y)
;;
/* Result: 3 */

let x = 2;
let z = x+2;
let k = (let x = z+2; x*x);
k+k;;
/* Result: 72 */

let y = 1;
let b = (y > 0) && (y <= 20);
let z = (let z = 2*y;  z*z);
b || ~ (z < 0)
;;
/* Result: true */

/* tests for L1 step 2 */

let x = 1;
let f = fn y => { x + y };
(x + f (2));;
/* Result: 4 */

let x=1 ;			 
let f = fn y => { y+x } ;
let g = fn x => { x+f(x) };
g(2) 
;;
/* Result: 5 */

let f = fn g,z => { g (z) };
f (fn z => { z*2 }) (7)
;;
/* Result: 14 */

(fn z => { fn t => { z*t }}) (7) (7);;
/* Result: 49 */

(fn z,t => { z*t }) (7) (7);;
/* Result: 49 */

let x=1 ;			 
let f = fn y => {
           let k = x*2;
  	   y+x*k
        };
let g = fn x, u =>
           { u(x) + f(x) };
g  (f(3)) (f) 
;;
/* Result: 14 */

let comp = fn f, g => 
        { fn x =>
        { f (g (x)) }};
let inc = fn x => { x + 1};
let dup = fn x => { 2 * x};
let c2 = comp (inc) (dup);
c2 (99)
;;
/* Result: 199 */

/* Tests for comparison operators (EQ, GT, LT, GTEQ, LTEQ, DIF, NOT) */

let x = 5;
let y = 10;
(x == y);;
/* Result: false */

let x = 5;
let y = 10;
(x ~= y);;
/* Result: true */

let x = 5;
let y = 10;
(x < y);;
/* Result: true */

let x = 5;
let y = 10;
(x > y);;
/* Result: false */

let x = 5;
let y = 10;
(x <= y);;
/* Result: true */

let x = 5;
let y = 10;
(x >= y);;
/* Result: false */

let x = 5;
let y = 10;
~(x == y);;
/* Result: true */

/* Tests for ASTBox and ASTStar */

let x = box 5;
*x;;         
/* Result: 5 */
let x = box 5;
x := 10;
*x;;         
/* Result: 10 */

let x = box box box (2 + 3);
***x + 4;

/* Tests for ASTWhile */

let x = box 0;
while (*x < 5) {
  x := *x + 1
};
*x;;
/* Result: 5 */

let i = box 10;
let y = box box 3;
while ( ( let x = *i ; i := *i - 1; x ) > 5 ) {
  *y := **y + 1
};
**y;;

/* Tests for ASTIf */

let x = box 10;
let y = 20;
if (*x < y) {
  *x + y
} else {
  *x - y
};;       
/* Result: 30 */

/* Tests for ASTAND and ASTOR */

let x = true;
let y = false;
(x && y);;   
/* Result: false */
(x || y);;   
/* Result: true */

/* Combined test: ASTWhile, ASTStar, ASTIf */

let x = box 0;
let y = box 1;
while (*x < 5) {
  if (*x > 2 == 0) {
    y := *y * 2
  } else {
    y := *y + 1
  };
};
*y;;         
/* Result: 18 */

/* Combined test: ASTBox, ASTStar, ASTAND, ASTOR */

let x = box true;
let y = box false;
if (*x && ~(*y)) {
  x := false
} else {
  y := true
};
*x;;         
/* Result: false */

let x = box true;
let y = box false;
if (*x && ~(~(*y))) {
  x := false
} else {
  y := true
};
*y;;         
/* Result: true */
