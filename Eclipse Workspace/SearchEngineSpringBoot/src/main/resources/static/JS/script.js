let y=document.getElementById('suggestionbox');
let x=document.getElementById('searchbox');
var request = new XMLHttpRequest();

let dummy=["a","b","c","d"];
y.hidden=true;
y.innerHTML="";
x.addEventListener("keyup",
                            ()=>{
                                //alert('activated');
                                //console.log('entered value = ',x.value);
                                //console.log(dummy);
                                if(x.value!=''){

                                    let url="http://192.168.1.4:8088/search/"+x.value;
                                    request.open("GET", url, false);
                                    request.send(null);
                                    let result = JSON.parse(request.responseText);
                                    //console.log(result);

                                    // let url="https://reqres.in/api/users?page=2";
                                    // request.open("GET", url, false);
                                    // request.send(null);
                                    // let result = JSON.parse(request.responseText);
                                    // console.log(result);

                                    // let res={"page":2,"data":["d1","d2","d3"]};
                                    // console.log("testing data... data res ::: ",res['data'][0]);

                                    y.hidden=false;
                                    let htmlcode = "<table class='table table-hover' border='2px solid'>"
                                    let hcode="";
                                    for(let i=0;i<result.length;i++)
                                    {
                                        hcode=hcode+"<tr onclick='setvalue(\""+result[i]+"\")'><td>"+result[i]+"</td></tr>";
                                    }
                                    if(result.length==0){hcode="<tr><td style='color:red;font-weight:bold;text-align: center;'>No Results Found!!!</td></tr>"}
                                    htmlcode=htmlcode+hcode+"</table>"
                                    y.innerHTML=htmlcode;
                                    //y.innerHTML="<table class='table table-hover' border='2px solid'><tr><td>a</td></tr><tr><td>b</td></tr><tr><td>c</td></tr><tr><td>d</td></tr></table>"
                                    } else {
                                        y.hidden=true;
                                        y.innerHTML="";
                                    }
                            });
    function setvalue(val) {
        x.value=val;
        y.hidden=true;
    }