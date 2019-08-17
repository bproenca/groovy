package tmp

pattern = ~/\|[A-Za-z]+\|I[AS]\|/


def conteudo = new File("/home/bcp/Documents/wks/wks_syn/Groovy_Scripts/src/tmp/arquivo_entrada_quebra.txt").text()

if (conteudo =~ pattern) {
    entidade = line.split(/\|/)[1]
    coluna = line.split(/\|/).size() - 1
    ultLn = line
}