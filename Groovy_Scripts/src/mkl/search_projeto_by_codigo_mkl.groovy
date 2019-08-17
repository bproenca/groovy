package mkl

this.class.classLoader.rootLoader.addURL(new URL("file:///home/bcp/wks/Groovy_Scripts/lib/ojdbc14.jar"))
def sql = groovy.sql.Sql.newInstance('jdbc:oracle:thin:@db-mikael.aws.synchro.com.br:1521:MIKAEL', 'SGI_RO', 'SYN@db04', 'oracle.jdbc.driver.OracleDriver')

print 'Código projeto to be found: '
def projeto = "${System.in.newReader().readLine()}"

printf "\n%-10s %-50s %-20s %-10s\n", '=======', '======', '====', '===='
printf "%-10s %-50s %-20s %-10s\n", 'Projeto', 'Titulo', 'CR', 'Nome'
printf "%-10s %-50s %-20s %-10s\n", '=======', '======', '====', '===='

sql.eachRow("select pr.codigo PROJETO, pr.titulo, cr.codigo CR, cr.nome from SGA_PROJETO pr join SGI_CENTRO_RESULTADO cr on pr.cr_id = cr.id where pr.CODIGO = ?", [projeto.toString().toUpperCase()]) {
    printf "%-10s %-50s %-20s %-10s\n",
            it.projeto,
            it.titulo.toString().substring(0, it.titulo.toString().length() > 49 ? 49 : it.titulo.toString().length()),
            it.cr,
            it.nome
}

println "\nFim busca por: ${projeto.toString().toUpperCase()}"