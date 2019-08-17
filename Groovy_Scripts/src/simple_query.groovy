def registro = System.console().readLine 'Nome do Registro (exemplo I050): '

this.class.classLoader.rootLoader.addURL( new URL("file:///d:/JavaD/_scripts/ojdbc14.jar") )
def sql = groovy.sql.Sql.newInstance('jdbc:oracle:thin:@localhost:1521:xe', 'SFW', 'SFW', 'oracle.jdbc.driver.OracleDriver' )

def contador = 0
printf "%-10s %-15s %s\n" , '======', '====', '==========='
printf "%-10s %-15s %s\n" , 'number', 'date', 'description'
printf "%-10s %-15s %s\n" , '======', '====', '==========='
sql.eachRow("select * from changelog order by change_number desc") {
    printf "%-10s %-15s %s\n" , it.change_number, new Date(it.complete_dt.timestampValue().getTime()).format('dd/MM/yyyy'), it.description
    if (++contador % 10 == 0) {
        def next = System.console().readLine 'Next 10 itens? ("n" to break)'
        if (next.equalsIgnoreCase('n')) System.exit(0)
    }
}
System.console().readLine '\nClick ENTER to quit'