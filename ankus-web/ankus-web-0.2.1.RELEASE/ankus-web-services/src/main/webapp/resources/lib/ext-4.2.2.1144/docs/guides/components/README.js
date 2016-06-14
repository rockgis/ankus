Ext.data.JsonP.components({"title": "Components", "guide": "<h1>Components</h1>\n<div class='toc'>\n<p><strong>Contents</strong></p>\n<ol>\n<li><a href='#!/guide/components-section-1'>The Component Hierarchy</a></li>\n<li><a href='#!/guide/components-section-2'>XTypes and Lazy Instantiation</a></li>\n<li><a href='#!/guide/components-section-3'>Showing and Hiding</a></li>\n<li><a href='#!/guide/components-section-4'>Floating Components</a></li>\n<li><a href='#!/guide/components-section-5'>Creating Custom Components</a></li>\n</ol>\n</div>\n\n<hr />\n\n<p>An Ext JS application's UI is made up of one or many widgets called <a href=\"#!/api/Ext.Component\" rel=\"Ext.Component\" class=\"docClass\">Component</a>s. All Components are subclasses of the <a href=\"#!/api/Ext.Component\" rel=\"Ext.Component\" class=\"docClass\">Ext.Component</a> class\nwhich allows them to participate in automated lifecycle management including instantiation, rendering, sizing and positioning, and destruction.\nExt JS provides a wide range of useful Components out of the box, and any Component can easily be extended to create a customized Component.</p>\n\n<h2 id='components-section-1'>The Component Hierarchy</h2>\n\n<p>A <a href=\"#!/api/Ext.container.Container\" rel=\"Ext.container.Container\" class=\"docClass\">Container</a> is a special type of Component that can contain other Components. A typical application is made up of many nested Components in a tree-like\nstructure that is referred to as the Component hierarchy.  Containers are responsible for managing the Component lifecycle of their children, which includes creation, rendering,\nsizing and positioning, and destruction. A typical application's Component hierarchy starts with a <a href=\"#!/api/Ext.container.Viewport\" rel=\"Ext.container.Viewport\" class=\"docClass\">Viewport</a> at the top,\nwhich has other Containers and/or Components nested within it:</p>\n\n<p><p><img src=\"guides/components/component_hierarchy.png\" alt=\"Component Hierarchy\"></p></p>\n\n<p>Child Components are added to a Container using the Container's <a href=\"#!/api/Ext.container.Container-cfg-items\" rel=\"Ext.container.Container-cfg-items\" class=\"docClass\">items</a> configuration property.  This example uses <a href=\"#!/api/Ext-method-create\" rel=\"Ext-method-create\" class=\"docClass\">Ext.create</a>\nto instantiate two <a href=\"#!/api/Ext.panel.Panel\" rel=\"Ext.panel.Panel\" class=\"docClass\">Panel</a>s, then adds those Panels as child Components of a Viewport:</p>\n\n<pre class='inline-example '><code>var childPanel1 = <a href=\"#!/api/Ext-method-create\" rel=\"Ext-method-create\" class=\"docClass\">Ext.create</a>('<a href=\"#!/api/Ext.panel.Panel\" rel=\"Ext.panel.Panel\" class=\"docClass\">Ext.panel.Panel</a>', {\n    title: 'Child Panel 1',\n    html: 'A Panel'\n});\n\nvar childPanel2 = <a href=\"#!/api/Ext-method-create\" rel=\"Ext-method-create\" class=\"docClass\">Ext.create</a>('<a href=\"#!/api/Ext.panel.Panel\" rel=\"Ext.panel.Panel\" class=\"docClass\">Ext.panel.Panel</a>', {\n    title: 'Child Panel 2',\n    html: 'Another Panel'\n});\n\n<a href=\"#!/api/Ext-method-create\" rel=\"Ext-method-create\" class=\"docClass\">Ext.create</a>('<a href=\"#!/api/Ext.container.Viewport\" rel=\"Ext.container.Viewport\" class=\"docClass\">Ext.container.Viewport</a>', {\n    items: [ childPanel1, childPanel2 ]\n});\n</code></pre>\n\n<p>Containers use <a href=\"#!/api/Ext.layout.container.Container\" rel=\"Ext.layout.container.Container\" class=\"docClass\">Layout Manager</a>s to size and position their child Components.\nFor more information on Layouts and Containers please refer to the <a href=\"guide/layouts_and_containers\">Layouts and Containers Guide</a>.</p>\n\n<p>See the <a href=\"guides/components/examples/container/index.html\">Container Example</a> for a working demo showing how to add Components to a Container using the items configuration.</p>\n\n<h2 id='components-section-2'>XTypes and Lazy Instantiation</h2>\n\n<p>Every Component has a symbolic name called an <code><a href=\"#!/api/Ext.Component-cfg-xtype\" rel=\"Ext.Component-cfg-xtype\" class=\"docClass\">xtype</a></code>. For example <a href=\"#!/api/Ext.panel.Panel\" rel=\"Ext.panel.Panel\" class=\"docClass\">Ext.panel.Panel</a> has an <code>xtype</code> of 'panel'.\nThe <code>xtype</code>s for all Components are listed in the <a href=\"#!/api/Ext.Component\" rel=\"Ext.Component\" class=\"docClass\">API Docs for Component</a>.\nThe above example showed how to add already instantiated <a href=\"#!/api/Ext.Component\" rel=\"Ext.Component\" class=\"docClass\">Component</a>s to a <a href=\"#!/api/Ext.container.Container\" rel=\"Ext.container.Container\" class=\"docClass\">Container</a>.\nIn a large application, however, this is not ideal since not all of the Components need to be instantiated right away,\nand some Components might never be instantiated depending on how the application is used. For example an application that uses a <a href=\"#!/api/Ext.tab.Panel\" rel=\"Ext.tab.Panel\" class=\"docClass\">Tab Panel</a>\nwill only need the contents of each tab to be rendered if and when each tab is clicked on by the user. This is where <code>xtype</code>s come in handy\nby allowing a Container's children to be configured up front, but not instantiated until the Container determines it is necessary.</p>\n\n<p>The following example code demonstrates lazy instantiation and rendering of a Container's Child components using a Tab Panel.\nEach tab has an event listener that displays an alert when the tab is rendered.</p>\n\n<pre><code><a href=\"#!/api/Ext-method-create\" rel=\"Ext-method-create\" class=\"docClass\">Ext.create</a>('<a href=\"#!/api/Ext.tab.Panel\" rel=\"Ext.tab.Panel\" class=\"docClass\">Ext.tab.Panel</a>', {\n    renderTo: <a href=\"#!/api/Ext-method-getBody\" rel=\"Ext-method-getBody\" class=\"docClass\">Ext.getBody</a>(),\n    height: 100,\n    width: 200,\n    items: [\n        {\n            // Explicitly define the xtype of this Component configuration.\n            // This tells the Container (the tab panel in this case)\n            // to instantiate a <a href=\"#!/api/Ext.panel.Panel\" rel=\"Ext.panel.Panel\" class=\"docClass\">Ext.panel.Panel</a> when it deems necessary\n            xtype: 'panel',\n            title: 'Tab One',\n            html: 'The first tab',\n            listeners: {\n                render: function() {\n                    <a href=\"#!/api/Ext.MessageBox-method-alert\" rel=\"Ext.MessageBox-method-alert\" class=\"docClass\">Ext.MessageBox.alert</a>('Rendered One', 'Tab One was rendered.');\n                }\n            }\n        },\n        {\n            // this component configuration does not have an xtype since 'panel' is the default\n            // xtype for all Component configurations in a Container\n            title: 'Tab Two',\n            html: 'The second tab',\n            listeners: {\n                render: function() {\n                    <a href=\"#!/api/Ext.MessageBox-method-alert\" rel=\"Ext.MessageBox-method-alert\" class=\"docClass\">Ext.MessageBox.alert</a>('Rendered One', 'Tab Two was rendered.');\n                }\n            }\n        }\n    ]\n});\n</code></pre>\n\n<p>Running this code results in an immediate alert for the first tab. This happens because it is the default active tab,\nand so its Container Tab Panel instantiates and renders it immediately.</p>\n\n<p><p><img src=\"guides/components/lazy_render1.png\" alt=\"Lazy Render 1\"></p></p>\n\n<p>The alert for the second tab does not get displayed until the tab is clicked on. This shows that the tab was not rendered until\nneeded, since the <code><a href=\"#!/api/Ext.Component-event-render\" rel=\"Ext.Component-event-render\" class=\"docClass\">render</a></code> event did not fire until the tab was activated.</p>\n\n<p><p><img src=\"guides/components/lazy_render2.png\" alt=\"Lazy Render 2\"></p></p>\n\n<p>For a working demo see the <a href=\"guides/components/examples/lazy_instantiation/index.html\">Lazy Instantiation Example</a></p>\n\n<h2 id='components-section-3'>Showing and Hiding</h2>\n\n<p>All <a href=\"#!/api/Ext.Component\" rel=\"Ext.Component\" class=\"docClass\">Component</a>s have built in <a href=\"#!/api/Ext.Component-method-show\" rel=\"Ext.Component-method-show\" class=\"docClass\">show</a> and <a href=\"#!/api/Ext.Component-method-hide\" rel=\"Ext.Component-method-hide\" class=\"docClass\">hide</a> methods.\nThe default CSS method used to hide the Component is \"display: none\", but this can be changed using the <a href=\"#!/api/Ext.Component-cfg-hideMode\" rel=\"Ext.Component-cfg-hideMode\" class=\"docClass\">hideMode</a> configuration:</p>\n\n<pre><code>var panel = <a href=\"#!/api/Ext-method-create\" rel=\"Ext-method-create\" class=\"docClass\">Ext.create</a>('<a href=\"#!/api/Ext.panel.Panel\" rel=\"Ext.panel.Panel\" class=\"docClass\">Ext.panel.Panel</a>', {\n    renderTo: <a href=\"#!/api/Ext-method-getBody\" rel=\"Ext-method-getBody\" class=\"docClass\">Ext.getBody</a>(),\n    title: 'Test',\n    html: 'Test Panel',\n    hideMode: 'visibility' // use the CSS visibility property to show and hide this component\n});\n\npanel.hide(); // hide the component\n\npanel.show(); // show the component\n</code></pre>\n\n<h2 id='components-section-4'>Floating Components</h2>\n\n<p>Floating <a href=\"#!/api/Ext.Component\" rel=\"Ext.Component\" class=\"docClass\">Component</a> are positioned outside of the document flow using CSS absolute positioning, and do not participate in their Containers' layout.\nSome Components such as <a href=\"#!/api/Ext.window.Window\" rel=\"Ext.window.Window\" class=\"docClass\">Window</a>s are floating by default, but any Component can be made floating using the <a href=\"#!/api/Ext.Component-cfg-floating\" rel=\"Ext.Component-cfg-floating\" class=\"docClass\">floating</a> configuration.</p>\n\n<pre><code>var panel = <a href=\"#!/api/Ext-method-create\" rel=\"Ext-method-create\" class=\"docClass\">Ext.create</a>('<a href=\"#!/api/Ext.panel.Panel\" rel=\"Ext.panel.Panel\" class=\"docClass\">Ext.panel.Panel</a>', {\n    width: 200,\n    height: 100,\n    floating: true, // make this panel an absolutely-positioned floating component\n    title: 'Test',\n    html: 'Test Panel'\n});\n</code></pre>\n\n<p>The above code instantiates a <a href=\"#!/api/Ext.panel.Panel\" rel=\"Ext.panel.Panel\" class=\"docClass\">Panel</a> but does not render it. Normally a Component either has a <code><a href=\"#!/api/Ext.Component-cfg-renderTo\" rel=\"Ext.Component-cfg-renderTo\" class=\"docClass\">renderTo</a></code>\nconfiguration specified, or is added as a child Component of a <a href=\"#!/api/Ext.container.Container\" rel=\"Ext.container.Container\" class=\"docClass\">Container</a>, but in the case of floating Components neither of these is needed.\nFloating Components are automatically rendered to the document body the first time their <a href=\"#!/api/Ext.Component-method-show\" rel=\"Ext.Component-method-show\" class=\"docClass\">show</a> method is called:</p>\n\n<pre><code>panel.show(); // render and show the floating panel\n</code></pre>\n\n<p>Here are a few other configurations and methods to make note of related to floating components:</p>\n\n<ul>\n<li><code><a href=\"#!/api/Ext.Component-cfg-draggable\" rel=\"Ext.Component-cfg-draggable\" class=\"docClass\">draggable</a></code> - enables dragging of a floating Component around the screen.</li>\n<li><code><a href=\"#!/api/Ext.Component-cfg-shadow\" rel=\"Ext.Component-cfg-shadow\" class=\"docClass\">shadow</a></code> - customizes the look of a floating Component's shadow.</li>\n<li><code><a href=\"#!/api/Ext.Component-method-alignTo\" rel=\"Ext.Component-method-alignTo\" class=\"docClass\">alignTo()</a></code> - aligns a floating Component to a specific element.</li>\n<li><code><a href=\"#!/api/Ext.Component-method-center\" rel=\"Ext.Component-method-center\" class=\"docClass\">center()</a></code> - centers a floating Component in its Container.</li>\n</ul>\n\n\n<p>For a working demo of floating Component features see the <a href=\"guides/components/examples/floating_panel\">Floating Panel Example</a>.</p>\n\n<h2 id='components-section-5'>Creating Custom Components</h2>\n\n<h3>Composition or Extension</h3>\n\n<p>When creating a new UI class, the decision must be made whether that class should own an instance of a <a href=\"#!/api/Ext.Component\" rel=\"Ext.Component\" class=\"docClass\">Component</a>, or to extend that Component.</p>\n\n<p>It is recommended to extend the nearest base class to the functionality required. This is because of the automated lifecycle management Ext JS provides which\nincludes automated rendering when needed, automatic sizing and positioning of Components when managed by an appropriate layout manager,\nand automated destruction on removal from a <a href=\"#!/api/Ext.container.Container\" rel=\"Ext.container.Container\" class=\"docClass\">Container</a>.</p>\n\n<p>It is easier to write a new class which is a Component and can take its place in the Component hierarchy rather than a new class which has an Ext JS Component,\nand then has to render and manage it from outside.</p>\n\n<h3>Subclassing</h3>\n\n<p>The <a href=\"#!/api/Ext.Class\" rel=\"Ext.Class\" class=\"docClass\">Class System</a> makes it easy to extend existing Components.  The following example creates a subclass of <a href=\"#!/api/Ext.Component\" rel=\"Ext.Component\" class=\"docClass\">Ext.Component</a> without\nadding any additional functionality:</p>\n\n<pre><code><a href=\"#!/api/Ext-method-define\" rel=\"Ext-method-define\" class=\"docClass\">Ext.define</a>('My.custom.Component', {\n    extend: '<a href=\"#!/api/Ext.Component\" rel=\"Ext.Component\" class=\"docClass\">Ext.Component</a>'\n});\n</code></pre>\n\n<h3>Template Methods</h3>\n\n<p>Ext JS uses the <a href=\"http://en.wikipedia.org/wiki/Template_method_design_pattern\">Template method pattern</a> to delegate to subclasses, behavior which is specific only to that subclass.</p>\n\n<p>The meaning of this is that each class in the inheritance chain may \"contribute\" an extra piece of logic to certain phases in the Component's lifecycle.\nEach class implements its own special behavior while allowing the other classes in the inheritance chain to continue to contribute their own logic.</p>\n\n<p>An example is the render function. <code>render</code> is a private method defined in <a href=\"#!/api/Ext.Component\" rel=\"Ext.Component\" class=\"docClass\">Component</a>'s superclass,\n<a href=\"#!/api/Ext.AbstractComponent\" rel=\"Ext.AbstractComponent\" class=\"docClass\">AbstractComponent</a> that is responsible for initiating the rendering phase of the Component lifecycle.\n<code>render</code> must not be overridden, but it calls <code>onRender</code> during processing to allow the subclass implementor to add an <code>onRender</code>\nmethod to perform class-specific processing. Every <code>onRender</code> method must call its superclass' <code>onRender</code> method before \"contributing\" its extra logic.</p>\n\n<p>The diagram below illustrates the functioning of the <code>onRender</code> template method.</p>\n\n<p>The <code>render</code> method is called (This is done by a Container’s layout manager). This method may not be overridden and is implemented by the Ext base class.\nIt calls <code>this.onRender</code> which is the implementation within the current subclass (if implemented).\nThis calls the superclass version which calls its superclass version etc. Eventually, each class has contributed its functionality, and control returns to the <code>render</code> function.</p>\n\n<p><p><img src=\"guides/components/template_pattern.png\" alt=\"Template Pattern\"></p></p>\n\n<p>Here is an example of a Component subclass that implements the <code>onRender</code> method:</p>\n\n<pre><code><a href=\"#!/api/Ext-method-define\" rel=\"Ext-method-define\" class=\"docClass\">Ext.define</a>('My.custom.Component', {\n    extend: '<a href=\"#!/api/Ext.Component\" rel=\"Ext.Component\" class=\"docClass\">Ext.Component</a>',\n    onRender: function() {\n        this.callParent(arguments); // call the superclass onRender method\n\n        // perform additional rendering tasks here.\n    }\n});\n</code></pre>\n\n<p>It is important to note that many of the template methods also have a corresponding event. For example the <a href=\"#!/api/Ext.Component-event-render\" rel=\"Ext.Component-event-render\" class=\"docClass\">render</a>\nevent is fired after the Component is rendered.  When subclassing, however, it is it is essential to use template methods to perform class logic at\nimportant phases in the lifecycle and <em>not</em> events. Events may be programmatically suspended, or may be stopped by a handler.</p>\n\n<p>Below are the template methods that can be implemented by subclasses of Component:</p>\n\n<ul>\n<li><code>initComponent</code>\nThis method is invoked by the constructor. It is used to initialize data, set up configurations, and attach event handlers.</li>\n<li><code>beforeShow</code>\nThis method is invoked before the Component is shown.</li>\n<li><code>onShow</code>\nAllows addition of behavior to the show operation. After calling the superclass’s onShow, the Component will be visible.</li>\n<li><code>afterShow</code>\nThis method is invoked after the Component is shown.</li>\n<li><code>onShowComplete</code>\nThis method is invoked after the <code>afterShow</code> method is complete</li>\n<li><code>onHide</code>\nAllows addition of behavior to the hide operation. After calling the superclass’s onHide, the Component will be hidden.</li>\n<li><code>afterHide</code>\nThis method is invoked after the Component has been hidden</li>\n<li><code>onRender</code>\nAllows addition of behavior to the rendering phase.</li>\n<li><code>afterRender</code>\nAllows addition of behavior after rendering is complete. At this stage the Component’s Element will have been styled according to the configuration,\nwill have had any configured CSS class names added, and will be in the configured visibility and the configured enable state.</li>\n<li><code>onEnable</code>\nAllows addition of behavior to the enable operation. After calling the superclass’s onEnable, the Component will be enabled.</li>\n<li><code>onDisable</code>\nAllows addition of behavior to the disable operation. After calling the superclass’s onDisable, the Component will be disabled.</li>\n<li><code>onAdded</code>\nAllows addition of behavior when a Component is added to a Container. At this stage, the Component is in the parent Container's collection of child items.\nAfter calling the superclass's onAdded, the ownerCt reference will be present, and if configured with a ref, the refOwner will be set.</li>\n<li><code>onRemoved</code>\nAllows addition of behavior when a Component is removed from its parent Container. At this stage, the Component has been removed from its parent Container's\ncollection of child items, but has not been destroyed (It will be destroyed if the parent Container's autoDestroy is true, or if the remove call was passed a truthy second parameter).\nAfter calling the superclass's onRemoved, the ownerCt and the refOwner will not be present.</li>\n<li><code>onResize</code>\nAllows addition of behavior to the resize operation.</li>\n<li><code>onPosition</code>\nAllows addition of behavior to the position operation.</li>\n<li><code>onDestroy</code>\nAllows addition of behavior to the destroy operation. After calling the superclass’s onDestroy, the Component will be destroyed.</li>\n<li><code>beforeDestroy</code>\nThis method is invoked before the Component is destroyed.</li>\n<li><code>afterSetPosition</code>\nThis method is invoked after the Components position has been set.</li>\n<li><code>afterComponentLayout</code>\nThis method is invoked after the Component is laid out.</li>\n<li><code>beforeComponentLayout</code>\nThis method is invoked before the Component is laid out.</li>\n</ul>\n\n\n<h3>Which Class To Extend</h3>\n\n<p>Choosing the best class to extend is mainly a matter of efficiency, and which capabilities the base class must provide.\nThere has been a tendency to always extend <a href=\"#!/api/Ext.panel.Panel\" rel=\"Ext.panel.Panel\" class=\"docClass\">Ext.Panel</a> whenever any set of UI Components needs to be rendered and managed.</p>\n\n<p>The Panel class has many capabilities:</p>\n\n<ul>\n<li>Border</li>\n<li>Header</li>\n<li>Header tools</li>\n<li>Footer</li>\n<li>Footer buttons</li>\n<li>Top toolbar</li>\n<li>Bottom toolbar</li>\n<li>Containing and managing child Components</li>\n</ul>\n\n\n<p>If these are not needed, then using a Panel is a waste of resources.</p>\n\n<h4>Component</h4>\n\n<p>If the required UI Component does not need to contain any other Components, that is, if it just to encapsulate some form of HTML which performs the requirements,\nthen extending <a href=\"#!/api/Ext.Component\" rel=\"Ext.Component\" class=\"docClass\">Ext.Component</a> is appropriate. For example, the following class is a Component that wraps an HTML image element, and allows setting\nand getting of the image's <code>src</code> attribute. It also fires a <code>load</code> event when the image is loaded:</p>\n\n<pre><code><a href=\"#!/api/Ext-method-define\" rel=\"Ext-method-define\" class=\"docClass\">Ext.define</a>('Ext.ux.Image', {\n    extend: '<a href=\"#!/api/Ext.Component\" rel=\"Ext.Component\" class=\"docClass\">Ext.Component</a>', // subclass <a href=\"#!/api/Ext.Component\" rel=\"Ext.Component\" class=\"docClass\">Ext.Component</a>\n    alias: 'widget.managedimage', // this component will have an xtype of 'managedimage'\n    autoEl: {\n        tag: 'img',\n        src: Ext.BLANK_IMAGE_URL,\n        cls: 'my-managed-image'\n    },\n\n    // Add custom processing to the onRender phase.\n    // Add a ‘load’ listener to the element.\n    onRender: function() {\n        this.autoEl = <a href=\"#!/api/Ext-method-apply\" rel=\"Ext-method-apply\" class=\"docClass\">Ext.apply</a>({}, this.initialConfig, this.autoEl);\n        this.callParent(arguments);\n        this.el.on('load', this.onLoad, this);\n    },\n\n    onLoad: function() {\n        this.fireEvent('load', this);\n    },\n\n    setSrc: function(src) {\n        if (this.rendered) {\n            this.el.dom.src = src;\n        } else {\n            this.src = src;\n        }\n    },\n\n    getSrc: function(src) {\n        return this.el.dom.src || this.src;\n    }\n});\n</code></pre>\n\n<p>Usage:</p>\n\n<pre><code>var image = <a href=\"#!/api/Ext-method-create\" rel=\"Ext-method-create\" class=\"docClass\">Ext.create</a>('Ext.ux.Image');\n\n<a href=\"#!/api/Ext-method-create\" rel=\"Ext-method-create\" class=\"docClass\">Ext.create</a>('<a href=\"#!/api/Ext.panel.Panel\" rel=\"Ext.panel.Panel\" class=\"docClass\">Ext.panel.Panel</a>', {\n    title: 'Image Panel',\n    height: 200,\n    renderTo: <a href=\"#!/api/Ext-method-getBody\" rel=\"Ext-method-getBody\" class=\"docClass\">Ext.getBody</a>(),\n    items: [ image ]\n});\n\nimage.on('load', function() {\n    console.log('image loaded: ', image.getSrc());\n});\n\nimage.setSrc('http://www.sencha.com/img/sencha-large.png');\n</code></pre>\n\n<p>See the <a href=\"guides/components/examples/managed_image/index.html\">Managed Image Example</a> for a working demo. This example is for demonstration purposes only -\nthe <a href=\"#!/api/Ext.Img\" rel=\"Ext.Img\" class=\"docClass\">Ext.Img</a> class should be used for managing images in a real world application.</p>\n\n<h4>Container</h4>\n\n<p>If the required UI Component is to contain other Components, but does not need any of the previously mentioned additional capabilities of a <a href=\"#!/api/Ext.panel.Panel\" rel=\"Ext.panel.Panel\" class=\"docClass\">Panel</a>,\nthen <a href=\"#!/api/Ext.container.Container\" rel=\"Ext.container.Container\" class=\"docClass\">Ext.container.Container</a> is the appropriate class to extend. At the Container level, it is important to remember which <a href=\"#!/api/Ext.layout.container.Container\" rel=\"Ext.layout.container.Container\" class=\"docClass\">Layout</a>\nis to be used to render and manage child Components.</p>\n\n<p>Containers have the following additional template methods:</p>\n\n<ul>\n<li><code>onBeforeAdd</code>\nThis method is invoked before adding a new child Component. It is passed the new Component, and may be used to modify the Component, or prepare the Container in some way. Returning false aborts the add operation.</li>\n<li><code>onAdd</code>\nThis method is invoked after a new Component has been added. It is passed the Component which has been added. This method may be used to update any internal structure which may depend upon the state of the child items.</li>\n<li><code>onRemove</code>\nThis method is invoked after a new Component has been removed. It is passed the Component which has been removed. This method may be used to update any internal structure which may depend upon the state of the child items.</li>\n<li><code>beforeLayout</code>\nThis method is invoked before the Container has laid out (and rendered if necessary) its child Components.</li>\n<li><code>afterLayout</code>\nThis method is invoked after the Container has laid out (and rendered if necessary) its child Components.</li>\n</ul>\n\n\n<h4>Panel</h4>\n\n<p>If the required UI Component must have a header, footer, or toolbars, then <a href=\"#!/api/Ext.panel.Panel\" rel=\"Ext.panel.Panel\" class=\"docClass\">Ext.Panel</a> is the appropriate class to extend.</p>\n\n<p><em>Important</em>: A Panel is a Container. It is important to remember which <a href=\"#!/api/Ext.layout.container.Container\" rel=\"Ext.layout.container.Container\" class=\"docClass\">Layout</a> is to be used to render and manage child Components.</p>\n\n<p>Classes which extend <a href=\"#!/api/Ext.panel.Panel\" rel=\"Ext.panel.Panel\" class=\"docClass\">Ext.Panel</a> are usually highly application-specific and are generally used to aggregate other UI Components\n(Usually Containers, or form Fields) in a configured layout, and provide means to operate on the contained Components by means\nof controls in the <a href=\"#!/api/Ext.panel.Panel-cfg-tbar\" rel=\"Ext.panel.Panel-cfg-tbar\" class=\"docClass\">tbar</a> and the <a href=\"#!/api/Ext.panel.Panel-cfg-bbar\" rel=\"Ext.panel.Panel-cfg-bbar\" class=\"docClass\">bbar</a>.</p>\n\n<p>Panels have the following additional template methods:</p>\n\n<ul>\n<li><code>afterCollapse</code>\nThis method is invoked after the Panel is Collapsed.</li>\n<li><code>afterExpand</code>\nThis method is invoked after the Panel is expanded</li>\n<li><code>onDockedAdd</code>\nThis method is invoked after a docked item is added to the Panel</li>\n<li><code>onDockedRemove</code>\nThis method is invoked after a docked item is removed from the Panel</li>\n</ul>\n\n"});