package jbs
//def userName = System.console().readLine 'Name to be found:'
//def param = "%${userName}%"

//def nome = "CS.06.16_DESCONSOLIDADO.txt"
def nome = "arq_tst.txt"

File arqFinal = new File("./saida_${nome}")
if (arqFinal.exists()) {
  arqFinal.delete()
  println "Arquivo final excluido para recriacao"
}

def customLine = ""
new File("./${nome}").eachLine { line ->

	if (line.endsWith("|")) {
		arqFinal << ("${line}\n")
	} else {
		arqFinal << ("${line}")
	}

}

println "FIM!!"
