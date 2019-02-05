/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function confirmDelete()
{
  var x = confirm("Are you sure you want to delete?");
  if (x){
     myCommand(); 
  }
}

function editPizza(){
    var element = document.getElementById("form:saveButton").style.display="inline";
    document.getElementById("form:j_idt7").value = "Hejhej!";
    
}

console.log("JS Working!");


