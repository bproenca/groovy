

println new Date()
File arqFinal = new File("D:/JavaD/_scripts/ECD_TST/ECD_TESTE_SAIDA.TXT")
def contador = 0
def parametro = [:]
def retorno = null
def linhaAjustada = ''
def campos = null

GroovyShell shell = new GroovyShell()
def script = shell.parse(new File('tratar_linha_ECD.groovy'))
  
new File("D:/JavaD/_scripts/ECD_TST/ECD_TESTE.TXT").eachLine { line ->
  campos = line.split('\\|')
  parametro.put('registro', campos[1])
  parametro.put('linha', line)

  retorno = script.method(parametro)
  
  //remover
  if (campos[1] == 'I050' && contador < 10) {
    println retorno
    contador++
  }
    
  if (retorno) {
    linhaAjustada = line
  } else {
    linhaAjustada = retorno
  }
  retorno = null
  
  arqFinal << ("${linhaAjustada}\n")
}
println new Date()
System.console().readLine '\nProcesso finalizado com sucesso!! Click ENTER to quit'