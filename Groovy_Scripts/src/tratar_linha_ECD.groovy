

def method(parametro) {

  if (parametro['registro'] == 'I050') {
    return parametro['linha'].toLowerCase() 
  } else {
    return parametro['linha']
  }

}