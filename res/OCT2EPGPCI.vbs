Sub main

If ms = vbCancel Then
 exit sub
 end if   


crt.Screen.Synchronous = True


Dim user
user = "front"

Dim password
password = "front_ericsson"



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
crt.session.LogFileName = "C:/HC/OCT2EPGPCI.txt" 
crt.session.Log(true) , true

crt.Session.Connect ("/SSH2 /L " & user & " /PASSWORD " &  password & " /C AES-256-CTR " & RT1(j) & "" )

'crt.Session.Connect ("/SSH2 /L " & user & " /PASSWORD " &  password & " /C 3DES /M MD5 "  & RT1(j) & host & "" )

  crt.screen.WaitForString (">")
  crt.Screen.Send "show card" & VbCr 
  crt.screen.WaitForString (">")
  crt.Screen.Send "show chassis" & VbCr 
  crt.screen.WaitForString (">")
  crt.Screen.Send "show memory" & VbCr
  crt.screen.WaitForString (">")
  crt.Screen.Send "show ospf neighbor" & VbCr
  crt.screen.WaitForString (">")
  crt.Screen.Send "show port all" & VbCr
  crt.screen.WaitForString (">")
  crt.Screen.Send "show process" & VbCr
  crt.screen.WaitForString ("--More--") 
  crt.Screen.Send " "
  crt.screen.WaitForString (">")
  crt.Screen.Send "show redundancy" & VbCr
  crt.screen.WaitForString (">")
        crt.Screen.Send "start oam-cli" & VbCr
	crt.Screen.WaitForString (">")
	crt.Screen.Send "ManagedElement=1,Epg=1,Node=1,status" & VbCr
        crt.Screen.WaitForString (">")
	crt.Screen.Send "ManagedElement=1,Epg=1,Node=1,FaultManagement=1" & VbCr
	crt.Screen.WaitForString (">")
  crt.Screen.Send "activeNotifications" & VbCr
  crt.Screen.WaitForString (">")
  crt.Screen.Send "up" & VbCr
  crt.Screen.WaitForString (">")
  crt.Screen.Send "up" & VbCr
  crt.Screen.WaitForString (">")
	crt.Screen.Send "Pgw=1" & VbCr
	crt.Screen.WaitForString (">")
        crt.Screen.Send "Apn=internet.te.eg" & VbCr
	crt.Screen.WaitForString (">")
  crt.Screen.Send "statistics" & VbCr
  crt.Screen.WaitForString (">")
  crt.Screen.Send "exit" & VbCr
  crt.Screen.Send "show log" & VbCr
  crt.screen.WaitForString ("--More--") 
  crt.Screen.Send "                                                                                                                                            "
  crt.Screen.WaitForString (">")
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