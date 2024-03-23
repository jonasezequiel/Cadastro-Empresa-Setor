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

java
Copy code
@Entity
public class Pedido {
    // Outros atributos da entidade Pedido
    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    
    // Getters e setters
}
java
Copy code
@Entity
public class Cliente {
    // Outros atributos da entidade Cliente
    
    // Não é necessário definir o relacionamento inverso
    // O relacionamento será automaticamente bidirecional
    
    // Getters e setters
}
Anotação @OneToMany
A anotação @OneToMany é usada para definir um relacionamento um-para-muitos entre duas entidades. Isso significa que uma instância da primeira entidade está associada a várias instâncias da segunda entidade.

Exemplo de Uso
Continuando com o exemplo anterior, vamos adicionar o relacionamento @OneToMany para representar que um cliente pode ter vários pedidos:

java
Copy code
@Entity
public class Cliente {
    // Outros atributos da entidade Cliente
    
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;
    
    // Getters e setters
}
No exemplo acima, mappedBy = "cliente" indica que o relacionamento é mapeado pela propriedade cliente na entidade Pedido.

Conclusão
As anotações @ManyToOne e @OneToMany são ferramentas poderosas para modelar relacionamentos em um banco de dados relacional usando JPA. Elas facilitam a criação de associações entre entidades e ajudam a manter a consistência dos dados no sistema.
