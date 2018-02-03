
# $1 .... file name
# $2 .... command name


awk 'BEGIN{p=0} {if($0~/'"$2"'/){p=1} 
else if($0~/\[local\]/){p=0};
if(p==1) {print $0}
else {}}' "$1"
