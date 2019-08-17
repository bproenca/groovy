package old
//def userName = System.console().readLine 'Name to be found:'
//def param = "%${userName}%"

File arqSemPfj = new File("D:/Synchro/SFW/Cont�bil/Clientes/Honda/pri/HTA_JAN_14_SEM_PFJ.TXT")
File arqComPfj = new File("D:/Synchro/SFW/Cont�bil/Clientes/Honda/pri/HTA_JAN_14_APENAS_PFJ.TXT")

new File("D:/Synchro/SFW/Cont�bil/Clientes/Honda/pri/HTA JAN-14.TXT").eachLine { line ->
  def campos = line.split('\\|')
  
  if (campos[1] == 'Pfj' || campos[1] == 'PfjVigencia') {
    arqComPfj << ("${line}\n")
  } else {
    arqSemPfj << ("${line}\n")
  }
  
}

System.console().readLine '\nProcesso finalizado com sucesso!! Click ENTER to quit'