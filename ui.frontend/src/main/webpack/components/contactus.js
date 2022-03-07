
const form = document.querySelector('.contactus-form');


document.querySelector('.contactus-form').addEventListener('submit', function(e) {
    e.preventDefault();
    let formData = new FormData(this);
    let parsedData = {};

    for(let name of formData) {

      if (typeof(parsedData[name[0]]) == "undefined") {
        let tempdata = formData.getAll(name[0]);
        if (tempdata.length > 1) {
          parsedData[name[0]] = tempdata;
        } else {
          parsedData[name[0]] = tempdata[0];
        }
      }
    }

    let options = {};
    options.method = this.method;
    options.headers = {'Content-Type': 'application/json'};
    switch (this.method.toLowerCase()) {
      case 'post':
        options.body = JSON.stringify(parsedData);
        break;
      case 'get':
        options.headers = {'Content-Type': 'application/json'};
      break;
    }

    fetch(this.action, options).then(r => r.json()).then(data => {
      console.log(data);
    });
});