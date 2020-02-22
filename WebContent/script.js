function press_button() {                                        //method post
    document.getElementById('main_button');
    console.log('Servlet call++');
    var flag_print_cash_check = document.getElementById('cash_check').checked;
        if (flag_print_cash_check == true) {
         print_cash_check();   
        }
    var web_text = document.getElementById('web_text_area').value;
    var xhr = new XMLHttpRequest();
    
        xhr.onreadystatechange = function() {
            if (xhr.readyState == 4) {
                var data = xhr.responseText;
                var Obj = JSON.parse(data);
                document.getElementById("monitor").firstChild.nodeValue = " date: " + Obj.date;
                var omega = document.getElementById("monitor");
                
                omega.innerHTML =   
                "<table style=\"border: 0px solid black; width: 30%\">" +
                "<tr><td>&nbsp date: " + Obj.date +
                "<br>&nbsp begin_cash: " +
                "<br>&nbsp end_cash: " +
                "<br>&nbsp total_value_of_deals: " +
                "<br>&nbsp result income: " +
                "<br>&nbsp result payment: " +
                "<p>&nbsp (+Plus+)<br>&nbsp online_income: from sber: " +
                "<br>&nbsp income from nicom: " +
                "<br>&nbsp income from pults: " +
                "<br>&nbsp фнд: " + 
                "<br>&nbsp копия: " + 
                "<br>&nbsp печать: " + 
                "<br>&nbsp other: " + 
                "<br>&nbsp total**: " +
                "<p>&nbsp (-Minus-)<br>&nbsp payment for nicom: " +
                "<br>&nbsp payment for pults: " +
                "<br>&nbsp payment for baget: " +
                "<br>&nbsp payment for fotolab: " +
                "<br>&nbsp other: " +
                "<br>&nbsp salary: " + Obj.salary +
                "</td>" + 
                
                "<td>" + 
                "<br>" + Obj.beginCash + "<br>" + Obj.endCash +
                "<br>&nbsp-//-" +
                "<br>" + Obj.income +
                "<br>" + Obj.payment +
                "<p>" + 
                "<br>" + Obj.card +
                "<br>" + Obj.nicom +
                "<br>" + Obj.pults +
                "<br>" + Obj.foto +
                "<br>" + Obj.copy +
                "<br>" + Obj.print +
                "<br>" + Obj.other +
                "<br>" + (Obj.income - Obj.pults - Obj.nicom) +
                "<p>" +
                "<br>-" + Obj.nicomMinus +
                "<br>-" + Obj.pultsMinus +
                "<br>-" + Obj.bagetMinus +
                "<br>-" + Obj.fotolabMinus +
                "<br>-" + (Obj.payment - Obj.pultsMinus - Obj.nicomMinus - Obj.bagetMinus - Obj.fotolabMinus) +
                "<br>&nbsp" + 
                "</td></tr></table>"
            }
        }

        xhr.open('POST', 'ServletStandartMode', true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send("facture=" + web_text);
        
            }

function print_cash_check() {
     var for_arduino = new XMLHttpRequest();
     for_arduino.onreadystatechange = function() {
         if (for_arduino.readyState == 4) {
             //var html_text = for_delta.responseText;
//..from ServletOneItem we get simple html-text, and put it to html-page
             
             var flag = document.getElementById('cash_check').checked;
             //var x = document.getElementById("online_income_monitor").text;
             //omega.innerHTML = "<br>&nbsp";
             //omega.innerHTML = html_text;
         }
     }
     console.log('arduino++');
     for_arduino.open('POST', 'ServletArduino', true);
     for_arduino.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
     for_arduino.send("data_s=" + document.getElementById('cash_check').checked);
}

function get_html(abc) { 
    var z = "";
	
    for(let i = 0; i < abc.length; i++) {            
		 var y = "";
			 for(let k = 0; k < abc[i].online_income.length; k++) {
			 	y = y + abc[i].online_income[k] + "<br>";
			 }
		 
		z = z + "<table style=\"border: 1px solid black; width: 50%;\">" + 
	 	"<tr>" + "<td>date</td>" +
	 	"<td>" + y + "</td>" +
	 	"<td>total</td></tr></table>";
	 }
	return z;
}

function press_confirm() {
	 var date_one = document.getElementById('date_one').value;
	 var date_two = document.getElementById('date_two').value;
	
	var type_of_report = document.getElementById('list').value;
	console.log('function press confirm');
	//..analisis
     var for_delta = new XMLHttpRequest();
     for_delta.onreadystatechange = function() {

     }
     
     for_delta.open('POST', 'ServletReportMode', true);
     for_delta.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
     for_delta.send("date_one=" + date_one + "&date_two=" + date_two +
    		 "&type_of_report=" + type_of_report);
     
     var html = "";
     var list = document.getElementById('list').value;
     
     if (list == 'only one item') {
    	html = press_en();
     }
     
     if (list == 'online payment report') {
     	html = call_onliene_income();
     }
     
     if (list == 'standart chief report') {
      	html = call_chief_report();
      }
     
     if (list == 'classical report') {
       	html = call_classical_report();
       }
      
     
     var item = document.getElementById("monitor");
     item.innerHTML = list + html;
	
}

function press_en() {
	
	
	document.getElementById('engage');
	document.getElementById('one_item');
	//var setting = "setting.html"
	
	var xxx = document.getElementById('modul').text;
	 console.log('confirm');
	 console.log(xxx);
	 
//     var delta = document.getElementById("monitor");
//     delta.innerHTML = "<br>&nbsp" + xxx;
//	//..analisis
//	 
//	
//     var for_delta = new XMLHttpRequest();
//     for_delta.onreadystatechange = function() {
//         if (for_delta.readyState == 4) {
//             var from_delta = for_delta.responseText;
//             var abc = JSON.parse(from_delta);
//             console.log(abc[1].cash_gain);
//             var omega = document.getElementById("monitor");
//             omega.innerHTML = "<br>&nbsp";
//
//             omega.innerHTML = "one_tem";
//         }
//     }
     
//     for_delta.open('POST', 'ServletEpsa', true);
//     for_delta.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
//     for_delta.send("date_x=abcde");
     
return xxx;
}


function call_onliene_income() {
	
	//var setting = "setting.html"
	
	var xxx = document.getElementById('modulOnlineIncome').text;
	 console.log('call_onliene_income');
	 //console.log(xxx);
	
	//..analisis
     
return xxx;
}

function call_chief_report() {
	
	var xxx = "<br>&nbsp(Standart Chief Report Version Two)";
	 console.log('call_chief_report');
	 
	 var for_delta = new XMLHttpRequest();
     for_delta.onreadystatechange = function() {
         if (for_delta.readyState == 4) {
             var html_text = for_delta.responseText;
//..from ServletOneItem we get simple html-text, and put it to html-page
             
             var omega = document.getElementById("monitor");
        console.log('html_text: ' + html_text);
         xxx = xxx + html_text;
         console.log('xxx: ' + xxx);
         omega.innerHTML = xxx;
         }
     }
//КОСТЫЛЬ НА КОСТЫЛЕ ИБО ВСЕ СРОЧНЕЕ СРОЧНОГО!!!!!
     //ВСЁ ПЕРЕДЕЛАТЬ!!!!
     for_delta.open('POST', 'ServletStandartChiefReport', true);
     for_delta.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
     for_delta.send("data_s=StandartChiefReport");
     console.log('return xxx: ' + xxx);
return xxx;
}

function call_classical_report() {
	
	var xxx = "<br>&nbsp(Classical Report Version One)";
	 console.log('call_chief_report');
	 
	 var for_delta = new XMLHttpRequest();
     for_delta.onreadystatechange = function() {
         if (for_delta.readyState == 4) {
             var html_text = for_delta.responseText;
//..from ServletOneItem we get simple html-text, and put it to html-page
             
             var omega = document.getElementById("monitor");
        console.log('html_text: ' + html_text);
         xxx = xxx + html_text;
         console.log('xxx: ' + xxx);
         omega.innerHTML = xxx;
         }
     }
//КОСТЫЛЬ НА КОСТЫЛЕ ИБО ВСЕ СРОЧНЕЕ СРОЧНОГО!!!!!
     //ВСЁ ПЕРЕДЕЛАТЬ!!!!
     for_delta.open('POST', 'ServletClassicalReport', true);
     for_delta.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
     for_delta.send("data_s=StandartChiefReport");
     console.log('return xxx: ' + xxx);
return xxx;
}


function press_engage() {
	
	var item = document.getElementById('item').value;
	var configuration = document.getElementById('configuration').value;
	var total_gain = document.getElementById('total_gain').checked;
	var cash_gain = document.getElementById('cash_gain').checked;
	var online_income = document.getElementById('online_income').checked;
	var expense = document.getElementById('expense').checked;
	
	let one_object = {
			itm : item,
			con : configuration,
			cas : cash_gain,
			onl : online_income,
			exp : expense,
			tot : total_gain
			
			};
	var json = JSON.stringify(one_object);
	console.log("js obj: " + json);
	 
	
     var for_delta = new XMLHttpRequest();
     for_delta.onreadystatechange = function() {
         if (for_delta.readyState == 4) {
             var html_text = for_delta.responseText;
//..from ServletOneItem we get simple html-text, and put it to html-page
             
             var omega = document.getElementById("one_item_monitor");
             var x = document.getElementById("one_item_monitor").text;
             omega.innerHTML = "<br>&nbsp";

             omega.innerHTML = html_text;
         }
     }
     
     for_delta.open('POST', 'ServletOneItem', true);
     for_delta.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
     for_delta.send("date_x=" + json);
     
}
function press_online_income() {
	
	var configuration = document.getElementById('configuration').value;
	var sber = document.getElementById('sber').checked;
	
	
	let online_income_object = {
			con : configuration,
			sber : document.getElementById('sber').checked,
			tinkoff : document.getElementById('tinkoff').checked,
			pochta_bank : document.getElementById('pochta_bank').checked,
			total : document.getElementById('total').checked
			
			};
	var json = JSON.stringify(online_income_object);
	console.log("js obj: " + json);
	 
	
     var for_delta = new XMLHttpRequest();
     for_delta.onreadystatechange = function() {
         if (for_delta.readyState == 4) {
             var html_text = for_delta.responseText;
//..from ServletOneItem we get simple html-text, and put it to html-page
             
             var omega = document.getElementById("online_income_monitor");
             var x = document.getElementById("online_income_monitor").text;
             omega.innerHTML = "<br>&nbsp";

             omega.innerHTML = html_text;
         }
     }
     
     for_delta.open('POST', 'ServletOnlineIncome', true);
     for_delta.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
     for_delta.send("data_s=" + json);
     
}


