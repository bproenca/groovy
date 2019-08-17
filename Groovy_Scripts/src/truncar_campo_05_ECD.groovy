//def userName = System.console().readLine 'Name to be found:'
//def param = "%${userName}%"

File arqFinal = new File("D:/Synchro/SFW/Contábil/Clientes/JBS/SPED JBS S.A. 012014_saida.txt")
def contador = 0

new File("D:/Synchro/SFW/Contábil/Clientes/JBS/SPED JBS S.A. 012014.txt").eachLine { line ->
  def campos = line.split('\\|')
  def linhaAjustada = ''
  
  if (campos[1] == 'I050' && campos[5].length() > 2) {
    contador++
    def indice = campos[5].length() - 2 
    campos[5] = campos[5].substring(indice)
    campos.each {
      linhaAjustada += it + '|'
    }        
  } else {
    linhaAjustada = line
  }
  
  arqFinal << ("${linhaAjustada}\n")
}

println 'Qtd de registros ajustados: ' + contador
System.console().readLine '\nProcesso finalizado com sucesso!! Click ENTER to quit'