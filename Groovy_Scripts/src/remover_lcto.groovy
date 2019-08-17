//File arqOri = new File("D:/JavaD/_scripts/Remover_LCTO/_ECD_ENTRADA.txt")
//File arqDest = new File("D:/JavaD/_scripts/Remover_LCTO/_ECD_SAIDA.txt")
File arqOri = new File("D:\\Synchro\\SFW\\Cont�bil\\Clientes\\Unilever\\4664_01_2014_ECD.txt")
File arqDest = new File("D:\\Synchro\\SFW\\Cont�bil\\Clientes\\Unilever\\4664_01_2014_ECD_sem_lcto.txt")

arqDest.delete()

arqOri.eachLine { line ->
  def campos = line.split('\\|')
  
  //println campos[1]
  try {
    if (campos[1] == 'I200' || campos[1] == 'I250' || campos[1] == 'LancamentoContabil') {
      //
    } else {
  		arqDest << ("${line}\n")
    }
  } catch (all) {
    arqDest << ("${line}\n")
  }
  
}

System.console().readLine '\nProcesso finalizado com sucesso!! Click ENTER to quit'