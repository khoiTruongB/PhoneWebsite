/**
 * 
 */
function validate() {
  var u = document.getElementById("username").value;
  var p = document.getElementById("password").value;

  if (u == "") {
    alert("username is null");
    return false;
  }
  if (p == "") {
    alert("password is null");
    return false;
  }
  return true;
}
