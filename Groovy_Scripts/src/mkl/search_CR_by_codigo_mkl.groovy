package mkl

this.class.classLoader.rootLoader.addURL(new URL("file:///home/bcp/wks/Groovy_Scripts/lib/ojdbc14.jar"))
def sql = groovy.sql.Sql.newInstance('jdbc:oracle:thin:@db-mikael.aws.synchro.com.br:1521:MIKAEL', 'SGI_RO', 'SYN@db04', 'oracle.jdbc.driver.OracleDriver')

print 'Código to be found: '
def cod_cr = "${System.in.newReader().readLine()}"

printf "\n%-10s %-40s\n", '=======', '======'
printf "%-10s %-40s\n", 'Código', 'Nome'
printf "%-10s %-40s\n", '=======', '======'

sql.eachRow("select cr.codigo, cr.nome from SGI_CENTRO_RESULTADO cr where cr.CODIGO = ?", [cod_cr.toString().toUpperCase()]) {
    printf "%-10s %-40s\n", it.codigo, it.nome
}

println "\nFim busca por: ${cod_cr.toString().toUpperCase()}"