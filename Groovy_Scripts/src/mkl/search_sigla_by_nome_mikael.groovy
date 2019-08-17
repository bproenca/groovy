package mkl

this.class.classLoader.rootLoader.addURL(new URL("file:///home/bcp/wks/Groovy_Scripts/lib/ojdbc14.jar"))
def sql = groovy.sql.Sql.newInstance('jdbc:oracle:thin:@db-mikael.aws.synchro.com.br:1521:MIKAEL', 'SGI_RO', 'SYN@db04', 'oracle.jdbc.driver.OracleDriver')

print 'Name to be found: '
def userName = "${System.in.newReader().readLine()}"

printf "\n%-10s %-50s %-20s\n", '=====', '====', '===='
printf "%-10s %-50s %-20s\n", 'Sigla', 'Nome', 'CR'
printf "%-10s %-50s %-20s\n", '=====', '====', '===='
sql.eachRow("select usu.sigla, usu.nome, cr.codigo from mkl_usuario usu join SGI_CENTRO_RESULTADO cr on usu.CR_ID_GERENCIAL = cr.id where usu.sigla is not null and usu.ind_ativo = 'S' and usu.nome like ? order by usu.nome", [userName.toString()]) {
    printf "%-10s %-50s %-20s\n", it.sigla, it.nome, it.codigo
}

println("\nFim busca por: ${userName}")
