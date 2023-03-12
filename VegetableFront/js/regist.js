const requestURL = 'http://192.168.43.214:8080'

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
 

   


    function regist() {
        const body = { 
            firstName: document.querySelector(".first_name").value, 
            lastName: document.querySelector(".last_name").value,
            username: document.querySelector(".email").value,  
            password: document.querySelector(".password").value

          } 
          sendRequest('POST', requestURL + "/auth/registration", body) 
          .then(data => console.log(data)) 
          .catch(err => console.log(err))
          console.log("click");
    }