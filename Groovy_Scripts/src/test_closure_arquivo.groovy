def registro = System.console().readLine 'Nome do Registro (exemplo I050): '
def indiceStr = System.console().readLine 'Indice do Campo (começa no 1): '
def codigo = System.console().readLine 'Codigo replace: '

int indice = indiceStr.toInteger()             
File arquivo = new File("c:/temp/arq_entrada.txt")

arquivo.eachLine { line ->
  def campos = line.split('\\|')
  def linhaAjustada = ''
  
  if (campos[1] == registro) {
    def campo = campos[indice]
    println 'Campo antes do ajuste: ' + campo
    
    campo = campo.{codigo}
    println 'Campo após ajuste: ' + campo
  }
}

System.console().readLine '\nProcesso finalizado com sucesso!! Click ENTER to quit'

