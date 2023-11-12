package id.ac.unand.fti.si.pbo;



public class App {
    
    public static void main(String[] args) {
     /*
        Polimorfisme yang terjadi di sini adalah objek member1 dan member2  yang memiliki tipe data Member, tetapi sebenarnya dapat merujuk
        pada objek dari kelas-kelas turunannya (MemberGold dan MemberPlatinum)
    */
   Member member1 = new MemberGold("Fathur",313);
   /*
    Polimorfisme juga terjadi di sini dengan objek member2, yang merupakan instance dari kelas turunan MemberPlatinum.
   */
   Member member2 = new MemberPlatinum("Mustafa",29);
   /*
    Metode redeemPoin() dipanggil pada objek member1 dan member2, menunjukkan polimorfisme karena implementasi metode berbeda
    tergantung pada jenis objek yang sebenarnya (MemberGold atau MemberPlatinum).
    */

   member1.redeemPoin(50);
   member2.redeemPoin(60);
    }
}