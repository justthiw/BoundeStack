# BoundeStack
ADT: BoundedStack
เกี่ยวข้องกับหนังสือ โดยมีฟังก์ชั่น เพิ่ม-ลบหนังสือ และตรวจสอบว่ามีหนังสือซ้ำกันไหม 

หน้าที่ : เก็บข้อมูล Stack แบบ LIFO กำหนดจำนวนสูงสุดตอนสร้าง (เข้าหลัง-ออกก่อน)
Representation : private Obj[]
		 private int size_Stack
		 private int Max_Stack

AF : 
	Array แทนข้อมูลใน Stack โดยเรียงจากด้านล่างขึ้นด้านบน
RI : 
	Array ไม่เป็น null    
	0<=size<=max stack
	
Operation:
  1. push เพิ่มข้อมูลเข้าไปในstack (บนสุด)
  2. pop ส่งค่าบนสุดและลบค่านั้นออก
  3. peek ดูข้อมูลบนสุดแต่ไม่ลบ
  4. size บอกจำนวนที่อยู่ในstackตอนนี้
  5. isEmpty ตรวจสอบว่าstackมีข้อมูลหรือไม่
  6. isFull ตรวจสอบว่าstackเต็มหรือยัง
  7. contains ตรวจสอบชื่อซ้ำ


Spec : 
param pre post throws IllegalStateException
 1. push
	  param ค่าที่ต้องการเพิ่ม
	  pre ห้ามเพิ่มตอนที่stackเต็ม
	  post เพิ่มข้อมูลบนสุดของstack , size +1
	  throws IllegalStateException เมื่อ stack เต็ม
 2. pop
	  param -
	  pre stack ต้องไม่ว่าง
	          stackต้องไม่เป็นnull
	  post return ค่าบนสุดและลบ , size-1
	  throws NoSuchElementException ถ้า Stack ว่าง
 3. peek
	  param -
	  pre stack ต้องไม่ว่าง
	      stack ต้องไม่เป็นnull
	  post return ค่าบนสุดที่เหลือไม่เปลี่ยนแปลง
	  throws NoSuchElementException ถ้า Stack ว่าง
  4. size 
	  param -
	  pre -
	  post return จำนวนข้อมูลที่อยู่ใน stack
	  throws -
 5. isEmpty	
	  param -
	  pre -
	  post return true เมื่อใน stack ไม่มีข้อมูล
	            return false เมื่อใน stack มีข้อมูล
	  throws -
  6. isFull 
	  param -
	  pre -
	  post return true เมื่อใน stack มีข้อมูลเต็ม
	            return false เมื่อใน stack ยังมีพื้นที่เหลือ
	  throws -
  7. contains
    param -
	  pre ชื่อหนังสือไม่เป็น null
	  post return true เมื่อใน stack มีข้อมูลเหมือนกันอย่างน้อย1อัน
	          return false เมื่อใน stack ไม่มีชื่อซ้ำ
	throws IllegalStateException ถ้าชื่อหนังสือเป็นnull
