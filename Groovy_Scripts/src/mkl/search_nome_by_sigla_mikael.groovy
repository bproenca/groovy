package mkl

//this.class.classLoader.rootLoader.addURL( new URL("file:///d:/JavaD/_scripts/ojdbc14.jar") )
this.class.classLoader.rootLoader.addURL(new URL("file:///home/bcp/wks/Groovy_Scripts/lib/ojdbc14.jar"))
def sql = groovy.sql.Sql.newInstance('jdbc:oracle:thin:@db-mikael.aws.synchro.com.br:1521:MIKAEL', 'SGI_RO', 'SYN@db04', 'oracle.jdbc.driver.OracleDriver')

//def sigla = System.console().readLine 'Sigla to be found:'
print 'Sigla to be found: '
def sigla = "${System.in.newReader().readLine()}"

//println "Sigla Nome"
printf "\n%-10s %-30s%s\n", '=====', '====', '=='
printf "%-10s %-30s%s\n", 'Sigla', 'Nome', 'CR'
printf "%-10s %-30s%s\n", '=====', '====', '=='

sql.eachRow("select usu.sigla, usu.nome, cr.codigo from mkl_usuario usu join sgi_centro_resultado cr on usu.cr_id_gerencial = cr.id where usu.sigla = ? order by usu.nome", [sigla.toString().toUpperCase()]) {
    printf "%-10s %-30s%s\n", it.sigla, it.nome, it.codigo
}

println "\nFim busca por: ${sigla.toUpperCase()}"