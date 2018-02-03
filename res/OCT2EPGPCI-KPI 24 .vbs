Sub main

If ms = vbCancel Then
 exit sub
 end if   


crt.Screen.Synchronous = True


Dim user
user = "ahmed"

Dim password
password = "Ericss@n1"



Dim RT1(1)
'Pop list 
RT1(1)= "172.22.4.166" 'OCT2EPGPCI'



'*******************************************************************

Dim RTTXT1(1)
'Header Text

RTTXT1(1)="OCT2EPGPCI"

for j=1 to 1

 crt.window.Caption  = RTTXT1(j)
On Error Resume Next
crt.session.LogFileName = "C:/HC/OCT2EPGPCI-KPI24.txt" 
crt.session.Log(true) , true

crt.Session.Connect ("/SSH2 /L " & user & " /PASSWORD " &  password & " /C AES-256-CTR " & RT1(j) & "" )

'crt.Session.Connect ("/SSH2 /L " & user & " /PASSWORD " &  password & " /C 3DES /M MD5 "  & RT1(j) & host & "" )

crt.screen.WaitForString ("#")
  crt.Screen.Send "start shell" & VbCr 
  crt.screen.WaitForString ("bash-4.2$")
  crt.Screen.Send "epg_healthcheck_kpi -n39" & VbCr 
  crt.screen.WaitForString ("bash-4.2$")
  crt.Screen.Send "exit" & VbCr
  crt.screen.WaitForString ("#")
  crt.Screen.Send "exit" & VbCr
  

crt.Screen.WaitForString "username:"
crt.Screen.Send user & VbCr
crt.Screen.WaitForString "password:"
crt.Screen.Send password & VbCr 

 crt.sleep 10 
'crt.Screen.Send " ============================================================================================ " & VbCr 
 crt.screen.WaitForString (">")
 crt.Session.Disconnect
next

               MsgBox "Finished", vbOKOnly
               end sub  