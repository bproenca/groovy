package file

input = ["Nf 9", "Nf 99", "Nf 999", "Nf 9999", "", "Nf18", "Nf X", "Nf", "18"]

input.each {
    println it
    if (it =~ "[A-Za-z]+[ \t][0-9]+")
        println "ok\n"
    else
        println "NAO ok\n"


}



println '\n*** FIM ***'

