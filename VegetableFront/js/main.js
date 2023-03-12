const requestURL = 'http://192.168.43.214:8080'



$(document).ready(function () {
  $("select").selectize({
    sortField: "text",
  });
});

let gumw = document.getElementById('gumch')
let rasul = document.getElementById('elem')
let you = document.getElementById('elem')
const gfgh = document.querySelector(".gum_sch")


function gum() {  
    gumw.style = "display:flex;"
    console.log("click");
  }  
  function isa (){
      rasul.style = "display:flex;"
  }
  function is() {
      you.style = "display:none;"
  } 









 
function sendRequest(method, url, body = null) { 
    const headers = { 
      'Content-Type': 'application/json' 
    } 
   
    return fetch(url, { 
      method: method, 
      body: JSON.stringify(body), 
      headers: headers 
    }).then(response => { 
      if (response.ok) { 
        return response.json() 
      } 
   
      return response.json().then(error => { 
        const e = new Error('Что-то пошло не так') 
        e.data = error 
        throw e 
      }) 
    }) 
  } 
 

   


    function info() {
        const body = { 
            username: document.querySelector(".email").value, 
            password: document.querySelector(".password").value
          } 
          sendRequest('POST', requestURL + "/auth/login", body) // /auth/registration
          .then(data => console.log(data)) 
          .catch(err => console.log(err))
    }