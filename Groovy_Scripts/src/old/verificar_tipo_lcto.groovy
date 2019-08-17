package old
//def userName = System.console().readLine 'Name to be found:'
//def param = "%${userName}%"

File arqFinal = new File("C:/Users/bruno.proenca/Desktop/MGW/SpedContabil-45347853000132_35203117572_20141201_20141231_G/ECD_LCTO_MGS_SEM_ASSIN.txt")

new File("C:/Users/bruno.proenca/Desktop/MGW/SpedContabil-45347853000132_35203117572_20141201_20141231_G/ECD_MGS_SEM_ASSIN.txt").eachLine { line ->
  def campos = line.split('\\|')
  
  if (campos[1] == 'I200') {
    arqFinal << ("${line}\n")
  }
  
}

System.console().readLine '\nProcesso finalizado com sucesso!! Click ENTER to quit'