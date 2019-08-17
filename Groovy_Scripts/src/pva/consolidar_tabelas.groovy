package pva
//def filePath = 'D:/CVS/SFW/ECF/Legislacao/Tabelas'

if (!args || args.size() != 1) {
	println "Parâmetro NÃO informado"
	System.exit(1)
} else if (!args[0]) {
	println "Diretório de trabalho NÃO informado"
	System.exit(1)
}
println "Diretório de trabalho informado: ${args[0]}"

def filePath = args[0].toString().trim()
File diretorioRaiz = new File(filePath)

//*** Passo #2 - varrer todos diretórios
diretorioRaiz.eachFile() { dir ->

  if (dir.isDirectory() && dir.getName().startsWith("201")) {
    println "Diretório ${dir}"

	//*** Passo #3 - consolidar arquivos
	File arqConsolidado = new File("${dir}/_todas_tabelas.txt")
	if (arqConsolidado.exists()) {
		println "${arqConsolidado} já existe"
	} else {
		dir.listFiles().sort{ it.name }.each { arq ->
		  if ("metadados".equals(arq.getName())) {
			 println "Ignogar arquivo ${arq}"
		  } else {
			   arqConsolidado << ("Arquivo: ${arq.getName()}\n")
			   arq.eachLine { line ->
			     //println line
			     arqConsolidado << ("${line}\n")
			   }
		  }
	   }
	}
	  
	File diretorioResultado = new File("${filePath}/resultados")
	if (!diretorioResultado.exists()) {
	  diretorioResultado.mkdir()
  }
	  
	File arqFinal = new File("${filePath}/resultados/${dir.getName()}.txt")
	arqFinal.delete()
	arqFinal << arqConsolidado.text
  }
}




