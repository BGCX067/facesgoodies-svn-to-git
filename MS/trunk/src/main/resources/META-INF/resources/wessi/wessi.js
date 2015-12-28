var wessi = {};
wessi.txt;

wessi.mouseover = function(elem)
{
  wessi.txt = elem.innerHTML;
  elem.innerHTML = "Some inportant information..."
}

wessi.mouseout = function(elem)
{
  elem.innerHTML = wessi.txt;
}