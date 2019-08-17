package shell
// nesse exemplo, chama um método de outra classe passando parametros (mapa)

parametro = ['nome':'bruno']
def retorno = ''
new GroovyShell().parse( new File( 'rotina_A.groovy' ) ).with {
  retorno = method(parametro)
}

println 'Retorno: ' + retorno
println "Fim!!"