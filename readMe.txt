# OOP3_ASSIGNMENT1 - Complexity and Sorting

Author:  
- Daisy Di  
- An-Ni Huang  
- Chen Li  
- Xiaoshan Wang  

Java Version: Java 8 (or your actual version)  
IDE: Eclipse (or your IDE)

----------------------------
1. Program Description
----------------------------

This application sorts 3D shapes based on selected properties: height, volume, or base area.  
It supports six sorting algorithms:

- Bubble Sort  
- Insertion Sort  
- Selection Sort  
- Merge Sort  
- Quick Sort  
- Heap Sort (custom implementation)

It also benchmarks the sorting time.

----------------------------
2. Installation & Compilation
----------------------------

To compile from source:

1. Open the project in your IDE (e.g., Eclipse).
2. Build the project to generate `Sort.jar`.

Or use the provided `Sort.jar` if you don't need to modify the source.

----------------------------
3. How to Run the Program
----------------------------

Run via command line:
java -jar Sort.jar -f <file_path> -t <property> -s <algorithm>


- `<file_path>`: path to input file (e.g., `res/shapes1.txt`)  
- `<property>`: sorting key:  
  - `h` = height  
  - `v` = volume  
  - `a` = base area  
- `<algorithm>`: sorting algorithm code:  
  - `b` = Bubble Sort  
  - `i` = Insertion Sort  
  - `s` = Selection Sort  
  - `m` = Merge Sort  
  - `q` = Quick Sort  
  - `z` = Heap Sort (custom)

**Notes:**  
- Arguments are case-sensitive and should be lowercase.  
- You can specify flags in any order.  
- Both `-f filename` and `-ffilename` styles are supported.

----------------------------
4. Example Usage
----------------------------

```bash
java -jar Sort.jar -f res/shapes1.txt -t h -s q
java -jar Sort.jar -s m -f res/shapes2.txt -t v
java -jar Sort.jar -t a -s z -f "res/shapesBig.txt"

