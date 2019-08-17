package file

pattern = ~/\|[A-Za-z]+\|I[AS]\|/

//def nome = "karina_efd_contribuições_220816.txt"
//def nome = "Synchro Prod - ABR2016_12.08.txt"
//def nome = "CS.06.16_DESCONSOLIDADO.txt"
//def nome = "arq_tst.txt"

def mySet = new HashSet()
def entidade = ""
def coluna = 0
def ultLn = ""

new File("/home/bcp/Downloads/ARQ/Tmp").eachFile() { arq ->
    println arq.getAbsolutePath()

    if (!arq.isDirectory()) {
        arq.eachLine { line ->
            if (line =~ pattern) {
                entidade = line.split(/\|/)[1]
                coluna = line.split(/\|/).size() - 1
                ultLn = line
            }

            if ("".equals(line)) {
                mySet << "Entidade ${entidade} possui linha em branco. Campo ${coluna}"
                //println "Entidade ${entidade} possui linha em branco. Campo ${coluna}"
                //println ultLn
            } else if (!line.endsWith("|")) {
                mySet << "Entidade ${entidade} possui linha sem finalizador. Campo ${coluna}"
                //println "Entidade ${entidade} possui linha sem finalizador. Campo ${coluna}"
                //println ultLn
            }

        }
    }
    println()
    mySet.each {
        println it
    }
    mySet = new HashSet()
    println()
}

println "FIM!!"
