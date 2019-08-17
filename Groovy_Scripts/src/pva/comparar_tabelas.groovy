package pva

import java.security.MessageDigest

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

def fileResultadoComparacao = new File("${filePath}/resultados/_comparacao_MD5.txt")
fileResultadoComparacao.delete()

def dirResultado = new File("${filePath}/resultados")
dirResultado.listFiles().sort{ it.name }.each { arq ->
	MessageDigest digest = MessageDigest.getInstance("MD5")
	arq.withInputStream(){is->
		byte[] buffer = new byte[8192]
		int read = 0
		while( (read = is.read(buffer)) > 0) {
			digest.update(buffer, 0, read);
		}
	}
	byte[] md5sum = digest.digest()
	BigInteger bigInt = new BigInteger(1, md5sum)
	def strMd5 = bigInt.toString(16).padLeft(32, '0')
	
	strMd5 += " file >> ${arq.getName()}"
	println strMd5
	fileResultadoComparacao << "${strMd5}\n"
}

