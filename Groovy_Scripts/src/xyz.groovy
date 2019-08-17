def filePath = '.'

def dirResultado = new File("${filePath}/resultados")
dirResultado.listFiles().sort{ it.name }.reverse().each { arq ->
	println " file >> ${arq.getName()}"
}