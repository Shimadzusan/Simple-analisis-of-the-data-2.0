package arduino_unit;

import arduino.*;
import servlet_unit.Buffer;

/**
 * class PrintCashCheck предназначен для демонстрации возможности автоматической печати кассового чека
 * используя соответствующую опцию в веб-приложении. В силу сложившихся технических обстоятельств работу
 * кассового аппарата с USB-разъемом имитирует модуль Arduino, sketch для модуля закомментирован в нижней
 * части данного класса.
 * 
 * @author user
 */
public class PrintCashCheck extends Thread {
	
	@Override
	public void run() {
		try {
			Thread.sleep(2000);	//..ожидаем на всякий случай инициализации Buffer
			launch(getNumber(Buffer.getLastDeal()) + "");	//..пока печатаем только последнюю сделку
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void launch(String data) throws InterruptedException {
		Arduino arduino = new Arduino("COM3", 9600);
		arduino.openConnection();
		Thread.sleep(2000);
		arduino.serialWrite(data);
		arduino.closeConnection();	//..обязательно всегда закрываем соединение
	}

	private int getNumber(String text) {
		char[] ch = text.toCharArray();
		String number = "";
			for(int i = 0; i < ch.length; i++) {
				if(Character.isDigit(ch[i]))number += "" + ch[i];
			}	
		return Integer.parseInt(number);
	}

	/*	разобраться с class.path и исключениями:
	 *	java.lang.NoClassDefFoundError
	 *	java.lang.ClassNotFoundException
	 *	https://javarush.ru/groups/posts/817-6-java-iskljucheniy-kotorihe-presledujut-novichkov
	 *	
	 *	Important information!!!
	 *	The problem was solved after as addition necessary arduino-library into main Apache directory
	 */
}
/**	Sketch of the "firmware" for ARDUINO-MODULE

#include <Wire.h>                                                // Подключаем библиотеку для работы с аппаратной шиной I2C.
#include <iarduino_I2C_Matrix_8x8.h>                             // Подключаем библиотеку для работы с LED матрицей 8x8.
iarduino_I2C_Matrix_8x8 disp(0x09);                              // Объявляем объект disp для работы с LED матрицей 8x8, указывая её адрес на шине I2C.
                                                                 
void setup(){
    Serial.begin(9600);
    delay(500);                                                  // Ждём завершение переходных процессов связанных с подачей питания.
    disp.begin();                                                // Инициируем работу с LED матрицей 8x8.  
}

void loop(){
    if(Serial.available() > 0) {
      int my_number = Serial.parseInt();
      String s = String(my_number);

      String s0 = String(s.charAt(0));
      String s1 = String(s.charAt(1));
      String s2 = String(s.charAt(2));
      String s3 = String(s.charAt(3));
      String s4 = String(s.charAt(4));
      int v = s0.toInt();
      int w = s1.toInt();
      int x = s2.toInt();
      int y = s3.toInt();
      int z = s4.toInt();

      switch(s.length()) {
        case 1: {
          disp.print(v);delay(5000);
          disp.fillScr(X8_DOWN);delay(1000);
          disp.clrScr (X8_RIPPLES);delay(2000);
          break;
        }
        case 2: {
          disp.print(v);delay(5000);
          disp.fillScr(X8_DOWN);delay(1000);
          disp.print(w);delay(5000);
          disp.fillScr(X8_DOWN);delay(1000);
          disp.clrScr (X8_RIPPLES);delay(2000);
        break;
        }
        case 3: {
          disp.print(v);delay(5000);
          disp.fillScr(X8_DOWN);delay(1000);                       // Заливаем экран сверху вниз (светодиоды включаются  построчно сверху вниз).
          disp.print(w);delay(5000);
          disp.fillScr(X8_DOWN);delay(1000);
          disp.print(x);delay(5000);
          disp.fillScr(X8_DOWN);delay(1000);
          disp.clrScr (X8_RIPPLES);delay(2000);                    // Чистим   экран рябью (светодиоды выключаются хаотично и с задержками).
        break;
        }
        case 4: {
          disp.print(v);delay(5000);
          disp.fillScr(X8_DOWN);delay(1000);
          disp.print(w);delay(5000);
          disp.fillScr(X8_DOWN);delay(1000);
          disp.print(x);delay(5000);
          disp.fillScr(X8_DOWN);delay(1000);
          disp.print(y);delay(5000);
          disp.fillScr(X8_DOWN);delay(1000);
          disp.clrScr (X8_RIPPLES);delay(2000);
        break;
        }
        case 5: {
          disp.print(v);delay(5000);
          disp.fillScr(X8_DOWN);delay(1000);
          disp.print(w);delay(5000);
          disp.fillScr(X8_DOWN);delay(1000);
          disp.print(x);delay(5000);
          disp.fillScr(X8_DOWN);delay(1000);
          disp.print(y);delay(5000);
          disp.fillScr(X8_DOWN);delay(1000);
          disp.print(z);delay(5000);
          disp.fillScr(X8_DOWN);delay(1000);
          disp.clrScr (X8_RIPPLES);delay(2000);
        break;
        }
      }
    }
}
*/
