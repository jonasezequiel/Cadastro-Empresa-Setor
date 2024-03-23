Uso de @ManyToOne e @OneToMany em JPA


Introdução
Este projeto exemplifica o uso das anotações @ManyToOne e @OneToMany em JPA (Java Persistence API). Essas anotações são usadas para definir relacionamentos entre entidades em um modelo de banco de dados relacional.

Tecnologias Utilizadas
Java
JPA (Java Persistence API)
Hibernate (Implementação JPA)


Anotação @ManyToOne
A anotação @ManyToOne é usada para definir um relacionamento muitos-para-um entre duas entidades. Isso significa que uma entidade pode estar associada a várias instâncias de outra entidade, mas cada instância da segunda entidade está associada a apenas uma instância da primeira entidade.

Exemplo de Uso
Considere o exemplo de um relacionamento entre as entidades Pedido e Cliente. Um pedido pode pertencer a um único cliente, mas um cliente pode ter vários pedidos. Aqui está como o relacionamento seria definido com @ManyToOne:

Setor.java

@Entity
public class setor {
    // Outros atributos da entidade Setor
    
    @ManyToOne(cascade = CascadeType.REFRESH) 
    // Quando na tabela for para muitos se usa o ManyTo One
    private Empresa empresa;
    // Getters e setters
}


Empresa.java

@Entity
public class Empresa {
    // Outros atributos da entidade Empresa
    
    // Não é necessário definir o relacionamento inverso
    // O relacionamento será automaticamente bidirecional
    
    // Getters e setters
}


Anotação @OneToMany
A anotação @OneToMany é usada para definir um relacionamento um-para-muitos entre duas entidades. Isso significa que uma instância da primeira entidade está associada a várias instâncias da segunda entidade.

Exemplo de Uso
Continuando com o exemplo anterior, vamos adicionar o relacionamento @OneToMany para representar que um empresa pode ter vários setores:

Empresa.java


@Entity
public class Setores {
    // Outros atributos da entidade Setores
    
    @JsonIgnore
    @OneToMany(mappedBy = "empresa")
    private List<Setor> setores;
    
    // Getters e setters
}
No exemplo acima, mappedBy = "setor" indica que o relacionamento é mapeado pela propriedade setor na entidade Empresa.

A anotação `@JsonIgnore` foi usada na classe `Empresa` para evitar a serialização do campo `setores` para JSON. Isso pode ter sido feito por diversas razões:

**Evitar referências circulares:** Se a classe `Setor` tiver uma referência de volta para `Empresa`, como uma relação bidirecional, a serialização desses objetos para JSON pode causar uma referência circular. Isso pode levar a problemas de desempenho ou até mesmo a erros na serialização. Ao adicionar `@JsonIgnore` ao campo `setores`, você evita que o Jackson (biblioteca usada para serialização JSON) serialize esses objetos e evita a referência circular.

**Dados desnecessários:** Se os setores não são necessários ou relevantes para a representação JSON de uma empresa em um determinado contexto, você pode querer excluí-los para reduzir o tamanho da resposta JSON e melhorar a eficiência da comunicação pela rede.

**Confidencialidade:** Se os setores contêm informações confidenciais que não devem ser expostas através da API, é uma prática segura marcar esses campos com `@JsonIgnore` para garantir que não sejam incluídos na resposta JSON.

Em resumo, `@JsonIgnore` é usado para indicar ao framework de serialização JSON que o campo ou propriedade anotado não deve ser incluído na representação JSON do objeto. Isso é útil para vários fins, incluindo evitar referências circulares, reduzir o tamanho da resposta JSON e proteger informações confidenciais.

Conclusão
As anotações @ManyToOne e @OneToMany são ferramentas poderosas para modelar relacionamentos em um banco de dados relacional usando JPA. Elas facilitam a criação de associações entre entidades e ajudam a manter a consistência dos dados no sistema.


**OBSERVAÇÃO**
na application.properties:
    spring.jpa.hibernate.ddl-auto=update para atualizar a tabela
    spring.jpa.hibernate.ddl-auto=create para criar a tabela
